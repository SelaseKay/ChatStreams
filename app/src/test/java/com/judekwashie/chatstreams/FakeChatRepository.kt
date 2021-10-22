package com.judekwashie.chatstreams

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.judekwashie.chatstreams.api.SocketCallbacks
import com.judekwashie.chatstreams.data.Message
import com.judekwashie.chatstreams.server.FakeSocketServer
import io.socket.emitter.Emitter
import kotlinx.coroutines.*
import org.json.JSONObject

class FakeChatRepository(
    private val socket: FakeSocketServer
) : SocketCallbacks {

    companion object {
        const val TAG = "ChatRepository"
    }

    private var _isConnected = MutableLiveData(false)
    val isConnected: LiveData<Boolean> get() = _isConnected

    private val _newMessage = MutableLiveData<Message>()
    val newMessage: LiveData<Message> get() = _newMessage

    init {
        subscribeSocket()
    }

    suspend fun sendMessage(message: Message) {
        withContext(Dispatchers.IO) {
            socket.emit(Constants.EVENT_ON_NEW_MESSAGE, message)
        }
    }

    private fun subscribeSocket() {
        socket.on(Constants.EVENT_ON_CONNECT, onConnect())
        socket.on(Constants.EVENT_ON_NEW_MESSAGE, onNewMessage())
//        socket.on(Socket.EVENT_CONNECT_ERROR, SocketEventListeners.OnConnectError)
    }

    override fun onConnect(): Emitter.Listener {
        return Emitter.Listener {
                _isConnected.value = true
          }
        }

    override fun onDisconnect(): Emitter.Listener {
        return Emitter.Listener {
            _isConnected.value = false
        }
    }

    override fun onNewMessage(): Emitter.Listener {
        return Emitter.Listener {
//                val data = it[0] as JSONObject
//                var message = data.getString("message")
                val message = "Hey" // dummy message for testing sake
                val newMessage = Message(msg = message)
                _newMessage.value = newMessage
        }
    }
}