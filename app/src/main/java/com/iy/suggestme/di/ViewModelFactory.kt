package com.iy.suggestme.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iy.suggestme.ui.login.LoginActivity
import com.iy.suggestme.ui.login.LoginActivityViewModel
import com.iy.suggestme.ui.photos.MainActivityViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainActivityViewModel::class.java) -> {
                MainActivityViewModel() as T
            }
            modelClass.isAssignableFrom(LoginActivityViewModel::class.java) -> {
                LoginActivityViewModel() as T
            }
            else -> throw IllegalArgumentException("Unknown class name")
        }
    }
}