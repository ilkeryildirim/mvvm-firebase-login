package com.iy.suggestme.di.components

import com.iy.suggestme.di.modules.NetworkModule
import com.iy.suggestme.ui.login.LoginActivity
import com.iy.suggestme.ui.login.LoginActivityViewModel
import com.iy.suggestme.ui.photos.PhotosItemViewModel
import com.iy.suggestme.ui.photos.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(photosItemViewModel: PhotosItemViewModel)
    fun inject(mainActivityViewModel: MainActivityViewModel)
    fun inject(loginActivity: LoginActivityViewModel)

    @Component.Builder
    interface Builder {

        fun build(): ViewModelInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }

}