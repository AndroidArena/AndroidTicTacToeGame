package com.app.tictactoegame.data.di

import com.app.tictactoegame.BaseApplication_HiltComponents
import com.app.tictactoegame.data.Logics.TicTacToe1
import com.app.tictactoegame.data.WinningDataRepository
import com.app.tictactoegame.domain.Repository.WinningRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataRepositoryModule {

    @Singleton
    @Provides
    fun TicBoard() = TicTacToe1()

    @Singleton
    @Provides
    fun provideWinningRepository(
        ticTacToe1:TicTacToe1
    ) : WinningRepository = WinningDataRepository(ticTacToe1)
}