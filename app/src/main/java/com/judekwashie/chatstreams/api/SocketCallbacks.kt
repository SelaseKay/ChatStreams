package com.judekwashie.chatstreams.api

import com.github.nkzawa.emitter.Emitter

interface SocketCallbacks {
    fun onConnect(): Emitter.Listener
    fun onDisconnect(): Emitter.Listener
    fun onNewMessage(): Emitter.Listener
}