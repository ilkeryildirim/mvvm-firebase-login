package com.iy.suggestme.ui.login


import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.iy.suggestme.model.Photos
import com.iy.suggestme.api.ApiInterface
import com.iy.suggestme.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_login.view.*
import workOnBackground
import javax.inject.Inject

class LoginActivityViewModel : BaseViewModel() {

    @Inject
    lateinit var apiInterface: ApiInterface

    var loadingVisibility = MutableLiveData<Int>()
    var errorMessage: MutableLiveData<String> = MutableLiveData()
    val loginClickListener = View.OnClickListener{
        it.btLogin.setOnClickListener {login->
            println("++")
        }

    }


     private fun tryLogin() {

        showLoading()
    }

    private fun onPhotosRequestError(message: String) {
        errorMessage.value = message
    }

    private fun showLoading() {
        loadingVisibility.value = View.VISIBLE
    }

    private fun hideLoading() {
        loadingVisibility.value = View.INVISIBLE
    }
}

