package com.gzslt.boardgame.service

import android.content.Context
import com.gzslt.boardgame.service.impl.NetworkServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ServiceModule {

    @Singleton
    @Provides
    fun provideNetworkService(@ApplicationContext context: Context): NetworkService =
        NetworkServiceImpl(context)
}
