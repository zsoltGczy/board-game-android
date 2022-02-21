package com.gzslt.boardgame.data

import com.gzslt.boardgame.data.impl.BoardGameRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindBoardGameRepository(repository: BoardGameRepositoryImpl): BoardGameRepository
}
