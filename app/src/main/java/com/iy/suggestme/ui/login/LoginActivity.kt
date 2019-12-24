package com.iy.suggestme.ui.login

import android.content.Intent

import android.view.View

import androidx.lifecycle.Observer

import com.google.android.material.snackbar.Snackbar
import com.iy.suggestme.R
import com.iy.suggestme.base.BaseActivity
import com.iy.suggestme.databinding.ActivityLoginBinding


class LoginActivity(override val layoutId: Int =R.layout.activity_login) : BaseActivity<ActivityLoginBinding, LoginActivityViewModel>() {


    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginActivityViewModel
    private lateinit var errorSnackbar: Snackbar



     override fun initVariables() {

        binding.viewModel = viewModel
        viewModel.loadingVisibility.observe(this, Observer { visibility ->
            if (visibility == View.VISIBLE) showLoading() else hideLoading()
        })

        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            showError(errorMessage)
        })
        viewModel.registerButtonClicked.observe(this, Observer { boolean ->
         startActivity(Intent(this,RegisterActivity::class.java))
        })


    }


    private fun showError(error: String) {
        errorSnackbar = Snackbar.make(binding.root, error, Snackbar.LENGTH_LONG)
        errorSnackbar.show()
    }

    private fun hideLoading() {

    }

    private fun showLoading() {

    }
}
