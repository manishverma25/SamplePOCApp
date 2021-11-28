package com.manish.stockapp.di.module

import android.app.Application
import android.content.Context
import com.manish.stockapp.data.repository.*
import dagger.Binds
import dagger.Module


@Module
abstract class AppModule {



    @Binds
    abstract fun bindcontext(context: Application): Context

    @Binds
    abstract fun bindsFavoriteRepositoryUseCase(favoriteRepository: FavoriteRepository): FavoriteRepositoryDataSource

    @Binds
    abstract fun bindsDataRepositoryUseCase(networkDataRepository: NetworkRepository): NetworkRepositoryDataSource

    @Binds
    abstract fun bindsUserRepository(networkDataRepositoryImpl: UserProfileProfileRepository): UserProfileRepositoryDataSource

}