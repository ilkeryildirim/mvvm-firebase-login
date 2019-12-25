package com.iy.suggestme.ui.register


import android.annotation.SuppressLint
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.iy.suggestme.base.BaseViewModel


class RegisterActivityViewModel : BaseViewModel<Any?>() {


    var mail :String=""
    var password :String=""



    val registerClickListener=View.OnClickListener {
        tryRegister()
    }


    fun afterMailChange(s: CharSequence) {
        mail = s.toString()
        println(mail)
    }

    fun afterPasswordChange(s: CharSequence) {
        password = s.toString()
    }

    @SuppressLint("CheckResult")
    fun tryRegister() {
        showLoading()
        if (password.length > 6 && mail.length>4) {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(mail, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        errorMessage.value="Succes"

                    } else {
                        errorMessage.value=task.exception?.localizedMessage
                    }
                }
        }else{
            errorMessage.value="Requiered >6"
        }
    }

    private fun showLoading() {
        loadingVisibility.value = View.VISIBLE
    }

    private fun hideLoading() {
        loadingVisibility.value = View.INVISIBLE
    }
}

