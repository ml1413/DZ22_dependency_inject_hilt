package com.example.dz22_dependency_inject_hilt.module

import com.example.dz22_dependency_inject_hilt.Response.ApiClient
import com.example.dz22_dependency_inject_hilt.Response.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Provides
    @Singleton
    fun getApiClient(): ApiClient {
        return ApiClient()
    }

    @Provides
    @Singleton
    fun getRepository(apiClient: ApiClient): Repository {
        return Repository(retrofit = apiClient)
    }
}