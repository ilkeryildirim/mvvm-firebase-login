package com.iy.suggestme.di.components

import com.iy.suggestme.base.BaseActivity
import com.iy.suggestme.di.modules.NetworkModule
import com.iy.suggestme.ui.login.LoginActivityViewModel
import com.iy.suggestme.ui.login.RegisterActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(loginActivity: LoginActivityViewModel)
    fun inject(registerActivityViewModel: RegisterActivityViewModel)


    @Component.Builder
    interface Builder {

        fun build(): ViewModelInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }

}