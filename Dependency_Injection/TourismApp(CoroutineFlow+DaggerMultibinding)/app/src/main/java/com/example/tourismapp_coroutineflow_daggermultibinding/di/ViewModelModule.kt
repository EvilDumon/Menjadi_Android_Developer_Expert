package com.example.tourismapp_coroutineflow_daggermultibinding.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tourismapp_coroutineflow_daggermultibinding.core.ui.ViewModelFactory
import com.example.tourismapp_coroutineflow_daggermultibinding.detail.DetailTourismViewModel
import com.example.tourismapp_coroutineflow_daggermultibinding.favorite.FavoriteViewModel
import com.example.tourismapp_coroutineflow_daggermultibinding.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds @IntoMap @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds @IntoMap @ViewModelKey(FavoriteViewModel::class)
    abstract fun bindFavoriteViewModel(viewModel: FavoriteViewModel): ViewModel

    @Binds @IntoMap @ViewModelKey(DetailTourismViewModel::class)
    abstract fun bindDetailTourismViewModel(viewModel: DetailTourismViewModel): ViewModel

}