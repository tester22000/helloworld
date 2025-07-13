package com.eastgrams.lottoResultTvApp.di

import com.eastgrams.lottoResultTvApp.service.LottoDrawResultService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideLottoDrawResultService() : LottoDrawResultService {
        return LottoDrawResultService.create()
    }
}