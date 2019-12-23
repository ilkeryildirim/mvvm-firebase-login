package com.iy.suggestme.base

import androidx.lifecycle.ViewModel
import com.iy.suggestme.di.components.DaggerViewModelInjector
import com.iy.suggestme.di.components.ViewModelInjector
import com.iy.suggestme.di.modules.NetworkModule
import com.iy.suggestme.ui.login.LoginActivityViewModel
import com.iy.suggestme.ui.photos.PhotosItemViewModel
import com.iy.suggestme.ui.photos.MainActivityViewModel

abstract class BaseViewModel : ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()



    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is MainActivityViewModel -> injector.inject(this)
            is PhotosItemViewModel -> injector.inject(this)
            is LoginActivityViewModel -> injector.inject(this)
        }
    }
}

