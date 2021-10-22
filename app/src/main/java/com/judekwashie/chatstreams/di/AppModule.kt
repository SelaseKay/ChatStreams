package com.judekwashie.chatstreams.di

import com.github.nkzawa.socketio.client.IO
import com.github.nkzawa.socketio.client.Socket
import com.judekwashie.chatstreams.Constants
import com.judekwashie.chatstreams.Constants.SERVER_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import java.lang.RuntimeException
import java.net.URISyntaxException

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideSocket():Socket {
        return try {
            IO.socket(SERVER_URL)
        } catch (e: URISyntaxException) {
            throw RuntimeException(e)
        }
    }
}

