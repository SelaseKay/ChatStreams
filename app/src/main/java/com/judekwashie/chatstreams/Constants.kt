package com.judekwashie.chatstreams

import com.github.nkzawa.socketio.client.Socket

object Constants {
    const val SERVER_URL = "https://chat-streams.herokuapp.com/"
    const val EVENT_ON_NEW_MESSAGE = "new message"
    const val EVENT_ON_CONNECT = Socket.EVENT_CONNECT
    const val EVENT_ON_DISCONNECT = Socket.EVENT_DISCONNECT
}