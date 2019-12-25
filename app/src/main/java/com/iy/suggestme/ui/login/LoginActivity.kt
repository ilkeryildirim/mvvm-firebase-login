package com.iy.suggestme.ui.login



import android.content.Intent

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.auth.FirebaseAuth
import com.iy.suggestme.R
import com.iy.suggestme.base.BaseActivity
import com.iy.suggestme.databinding.ActivityLoginBinding
import com.iy.suggestme.di.ViewModelFactory
import com.iy.suggestme.ui.main.MainActivity
import com.iy.suggestme.ui.register.RegisterActivity


class LoginActivity : BaseActivity<ActivityLoginBinding, LoginActivityViewModel>() {


    private lateinit var viewModel: LoginActivityViewModel

    override fun initVariables() {
        baseViewModel = LoginActivityViewModel()
        baseViewModel.attachView(this)
        baseViewModel= ViewModelProviders.of(this, ViewModelFactory(this))
            .get(LoginActivityViewModel::class.java)
        viewModel = baseViewModel
        bindView(R.layout.activity_login)
        baseDataBinding.viewModel=viewModel

        if(FirebaseAuth.getInstance().currentUser!=null){
            startActivity(Intent(this,
                MainActivity::class.java))
        }

    }

    override fun observeViewModel() {
        super.observeViewModel()
        viewModel.registerButtonClicked.observe(this, Observer {
            startActivity(Intent(this,
                RegisterActivity::class.java))
        })
    }

}




