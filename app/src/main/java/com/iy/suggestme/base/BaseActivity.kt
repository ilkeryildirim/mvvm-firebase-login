package com.iy.suggestme.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar


abstract class BaseActivity<B : ViewDataBinding, T : BaseViewModel<*>> :
    AppCompatActivity() {
    lateinit var baseDataBinding: B
    lateinit var baseViewModel: T
    private lateinit var errorSnackbar: Snackbar

    protected fun bindView(layoutId: Int) {
        baseDataBinding = DataBindingUtil.setContentView(this, layoutId)
    }

    abstract fun initVariables()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initVariables()
        observeViewModel()

    }

    open fun observeViewModel() {
        baseViewModel.errorMessage.observe(this, Observer { errorMessage ->
            showError(errorMessage)
        })
        baseViewModel.loadingVisibility.observe(this, Observer { visibility ->
            if (visibility == View.VISIBLE) showLoading() else hideLoading()
        })
    }

    private fun showError(error: String) {
        errorSnackbar = Snackbar.make(baseDataBinding.root, error, Snackbar.LENGTH_LONG)
        errorSnackbar.show()
    }

    override fun onDestroy() {
        baseViewModel.detachView()
        super.onDestroy()
    }


    private fun hideLoading() {

    }

    private fun showLoading() {

    }
}