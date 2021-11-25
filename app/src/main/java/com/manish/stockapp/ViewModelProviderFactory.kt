package com.manish.stockapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.manish.stockapp.domain.FavoriteRepositoryImpl
import com.manish.stockapp.domain.NetworkDataRepositoryImpl
import com.manish.stockapp.ui.home.HomeViewModel


class ViewModelProviderFactory(
    val app: StockApplication,
    val networkDataRepositoryImpl: NetworkDataRepositoryImpl,
    val favoriteRepositoryImpl: FavoriteRepositoryImpl
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(app,networkDataRepositoryImpl, favoriteRepositoryImpl) as T
        }

        throw IllegalArgumentException("Unknown class name for ViewModelProviderFactory ...")
    }

}