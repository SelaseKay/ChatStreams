package com.judekwashie.chatstreams.ui.chat

import CoroutineTestRule
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.google.common.truth.Truth.assertThat
import com.jraska.livedata.test
import com.judekwashie.chatstreams.data.Message
import com.judekwashie.chatstreams.repository.ChatRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito


class ChatViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

//    @ExperimentalCoroutinesApi
//    val testCoroutineDispatcher = TestCoroutineDispatcher()
//
//    @ExperimentalCoroutinesApi
//    val testScope = TestCoroutineScope(testCoroutineDispatcher)

    val chatRepository: ChatRepository = mock()


    @ExperimentalCoroutinesApi
    @Test
    fun test_sendMessage() {
        val message = Message(
            "1",
            "Hey",
            "12:21",
            "Oct 9, 2021"
        )

        whenever(chatRepository.isConnected).thenReturn(
            MutableLiveData(true)
        )

        val model = ChatViewModel(chatRepository)
        val actual = model.isConnected.test().value()

        model.sendMessage(message)

        assertThat(actual).isTrue()

        runBlockingTest {
            verify(chatRepository).sendMessage(message)
        }
    }

}