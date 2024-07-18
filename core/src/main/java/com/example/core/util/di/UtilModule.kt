package com.example.core.util.di

import com.example.core.util.ResourceLoader
import com.example.core.util.ResourceLoaderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class UtilModule {
    @Binds
    internal abstract fun bindResourceLoader(impl: ResourceLoaderImpl): ResourceLoader
}