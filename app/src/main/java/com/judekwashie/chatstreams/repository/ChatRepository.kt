package com.judekwashie.chatstreams.repository


import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.github.nkzawa.emitter.Emitter
import com.github.nkzawa.socketio.client.Socket
import com.judekwashie.chatstreams.Constants
import com.judekwashie.chatstreams.api.SocketCallbacks
import com.judekwashie.chatstreams.data.Message
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject


class ChatRepository
@Inject constructor(
    private val socket: Socket,
) : SocketCallbacks {

    companion object {
        const val TAG = "ChatRepository"
    }

    val isConnected = mutableStateOf(true)
    val messages: MutableState<ArrayList<Message>> = mutableStateOf(ArrayList())

    init {
        subscribeSocketListeners()
    }

    fun sendMessage(message: Message) {
        socket.emit(Constants.EVENT_ON_NEW_MESSAGE, message)
    }

    private fun subscribeSocketListeners() {
        socket.on(Constants.EVENT_ON_CONNECT, onConnect())
        socket.on(Constants.EVENT_ON_DISCONNECT, onDisconnect())
        socket.on(Constants.EVENT_ON_NEW_MESSAGE, onNewMessage())
        socket.connect()

//        socket.on(Socket.EVENT_CONNECT_ERROR, SocketEventListeners.OnConnectError)
    }

    override fun onConnect(): Emitter.Listener {
        return Emitter.Listener {
            isConnected.value = true
        }
    }

    override fun onDisconnect(): Emitter.Listener {
        return Emitter.Listener {
            isConnected.value = false
        }
    }

    override fun onNewMessage(): Emitter.Listener {
        return Emitter.Listener {
            CoroutineScope(Dispatchers.Main).launch {
                val data = it[0] as JSONObject
                val msg = data.getString("message")
                updateMessages(msg)
            }
        }
    }

    private fun updateMessages(msg: String) {
        val newMessage = Message(msg = msg)
        messages.value.add(newMessage)
    }


}