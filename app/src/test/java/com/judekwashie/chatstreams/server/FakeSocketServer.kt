package com.judekwashie.chatstreams.server

import com.judekwashie.chatstreams.data.Message
import io.socket.emitter.Emitter

interface FakeSocketServer {

    companion object {
        const val TAG = "FakeSocketServer"

    }

    fun emit(event: String, message: Message)
    fun on(event: String, callback: Emitter.Listener)
}