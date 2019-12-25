package com.iy.suggestme.base


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iy.suggestme.di.components.DaggerViewModelInjector
import com.iy.suggestme.di.components.ViewModelInjector
import com.iy.suggestme.di.modules.NetworkModule
import com.iy.suggestme.ui.login.LoginActivityViewModel
import com.iy.suggestme.ui.register.RegisterActivityViewModel


abstract class BaseViewModel<T> : ViewModel() {

    var loadingVisibility = MutableLiveData<Int>()

    var errorMessage: MutableLiveData<String> = MutableLiveData()

    var view: T?=null

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    fun attachView(view: T) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is LoginActivityViewModel -> injector.inject(this)
            is RegisterActivityViewModel -> injector.inject(this)
        }
    }
}

