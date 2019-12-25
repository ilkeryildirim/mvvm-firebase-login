package com.iy.suggestme.ui.register


import androidx.lifecycle.ViewModelProviders
import com.iy.suggestme.R
import com.iy.suggestme.base.BaseActivity
import com.iy.suggestme.databinding.ActivityRegisterBinding
import com.iy.suggestme.di.ViewModelFactory

class RegisterActivity : BaseActivity<ActivityRegisterBinding, RegisterActivityViewModel>() {


    private lateinit var viewModel: RegisterActivityViewModel

    override fun initVariables() {
        baseViewModel = RegisterActivityViewModel()
        baseViewModel.attachView(this)
        baseViewModel= ViewModelProviders.of(this, ViewModelFactory(this))
            .get(RegisterActivityViewModel::class.java)
        viewModel = baseViewModel
        bindView(R.layout.activity_register)
        baseDataBinding.viewModel=viewModel

    }

    override fun observeViewModel() {
        super.observeViewModel()

    }

}