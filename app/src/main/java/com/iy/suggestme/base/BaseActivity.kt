package com.iy.suggestme.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.iy.suggestme.di.ViewModelFactory
import com.iy.suggestme.ui.login.LoginActivityViewModel


abstract class BaseActivity<B : ViewDataBinding, T : BaseViewModel<*>> :
    AppCompatActivity() {
    private lateinit var dataBinding: B
    private lateinit var baseViewModel: T


    abstract val layoutId:Int

    abstract fun initVariables()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        dataBinding = DataBindingUtil.setContentView(this, layoutId)
        baseViewModel = ViewModelProviders.of(this, ViewModelFactory(this))
            .get(T::class.java)
        initVariables()
    }

    override fun onDestroy() {
        baseViewModel.detachView()
        super.onDestroy()
    }
}