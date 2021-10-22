package com.judekwashie.chatstreams.ui.chat

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.judekwashie.chatstreams.data.Message
import com.judekwashie.chatstreams.repository.ChatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChatViewModel
@Inject constructor(
    private val chatRepository: ChatRepository
) : ViewModel(){

    val messages: MutableState<ArrayList<Message>> = chatRepository.messages
    val isConnected: MutableState<Boolean> = chatRepository.isConnected


    fun sendMessage(message: Message) {
        if(isConnected.value)
            chatRepository.sendMessage(message)
    }

}