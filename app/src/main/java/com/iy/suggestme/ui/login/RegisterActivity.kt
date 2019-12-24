package com.iy.suggestme.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.iy.suggestme.R
import com.iy.suggestme.databinding.ActivityRegisterBinding
import com.iy.suggestme.di.ViewModelFactory
import com.iy.suggestme.utils.ProgressDialog

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewModel: RegisterActivityViewModel
    private lateinit var errorSnackbar: Snackbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initVariables()
    }

    private fun initVariables() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        viewModel = ViewModelProviders.of(this, ViewModelFactory(this))
            .get(RegisterActivityViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.loadingVisibility.observe(this, Observer { visibility ->
            if (visibility == View.VISIBLE) showLoading() else hideLoading()
        })

        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            showError(errorMessage)
        })


    }


    private fun showError(error: String) {
        errorSnackbar = Snackbar.make(binding.root, error, Snackbar.LENGTH_LONG)
        errorSnackbar.show()
    }

    private fun hideLoading() {
        ProgressDialog().getProgressDialog(this).dismiss()
    }

    private fun showLoading() {
       ProgressDialog().getProgressDialog(this).show()
    }
}
