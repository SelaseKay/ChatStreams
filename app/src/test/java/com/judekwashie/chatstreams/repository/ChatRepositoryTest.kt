package com.judekwashie.chatstreams.repository


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.jraska.livedata.test
import com.judekwashie.chatstreams.Constants
import com.judekwashie.chatstreams.FakeChatRepository
import com.judekwashie.chatstreams.api.SocketCallbacks
import com.judekwashie.chatstreams.data.Message
import com.judekwashie.chatstreams.server.FakeSocketServer
import com.nhaarman.mockitokotlin2.*
import io.socket.client.Socket
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.json.JSONObject
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class ChatRepositoryTest {

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()


    @ExperimentalCoroutinesApi
    private val dispatcher = TestCoroutineDispatcher()

    @ExperimentalCoroutinesApi
    private val testScope = TestCoroutineScope(dispatcher)


    private val socket: FakeSocketServer = mock()
    private val chatRepository: FakeChatRepository = FakeChatRepository(socket)



    @ExperimentalCoroutinesApi
    @Test
    fun test_sendMessage() {
        val message = Message(
            "1",
            "Hey",
            "12:21",
            "Oct 9, 2021"
        )

        testScope.launch {
            chatRepository.sendMessage(message)
        }

        verify(socket).emit(Constants.EVENT_ON_NEW_MESSAGE, message)
    }

    @Test
    fun test_onConnect_IsConnected_true(){
        chatRepository.onConnect().call()

        assertThat(chatRepository.isConnected.test().value()).isTrue()
    }

    @Test
    fun test_onDisconnect_IsConnected_false(){
        chatRepository.onDisconnect().call()

        assertThat(chatRepository.isConnected.test().value()).isFalse()
    }


    @Test
    fun test_onNewMessage(){
        val msg = "Hey"
        val actual = Message(msg = msg)

        chatRepository.onNewMessage().call()

        assertThat(actual).isEqualTo(chatRepository.newMessage.value)
    }

}