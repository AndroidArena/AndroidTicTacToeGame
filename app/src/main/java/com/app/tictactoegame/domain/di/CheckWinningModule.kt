package com.app.tictactoegame.domain.di

import com.app.tictactoegame.data.Logics.TicTacToe1
import com.app.tictactoegame.data.WinningDataRepository
import com.app.tictactoegame.domain.Repository.WinningRepository
import com.app.tictactoegame.domain.usecases.CheckWinningUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn (SingletonComponent::class)
object CheckWinningModule {

    @Provides
    @Singleton
    fun provideWinningRepository(
        ticTacToe1: TicTacToe1
    ) = WinningDataRepository(ticTacToe1)



    @Provides
    @Singleton
    fun provideWinningUseCase(
         winningRepository: WinningRepository
    ) = CheckWinningUsecase(winningRepository)
}