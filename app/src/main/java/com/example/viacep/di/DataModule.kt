package com.example.viacep.di

import com.example.viacep.data.api.ServiceApi
import com.example.viacep.data.network.ServiceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideServiceApi(
        serviceProvides: ServiceProvider
    ): ServiceApi {
        return serviceProvides.createService(ServiceApi::class.java)
    }
}