package com.iy.suggestme.ui.login


import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.iy.suggestme.base.BaseViewModel


class LoginActivityViewModel : BaseViewModel<Any?>() {


    val registerButtonClicked=MutableLiveData<Boolean>()
    var mail :String=""
    var password :String=""


    val loginClickListener = View.OnClickListener {
        tryLogin()
    }

    val registerClickListener=View.OnClickListener {
        registerButtonClicked.value=true
    }


    fun afterMailChange(s: CharSequence) {
        mail = s.toString()
    }

    fun afterPasswordChange(s: CharSequence) {
        password = s.toString()
    }

    @SuppressLint("CheckResult")
    fun tryLogin() {
        if (password.length > 5 && mail.length>5) {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(
                mail,
                password
            ).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")

                    }else errorMessage.value=task.exception?.localizedMessage
                }
        }else{
            errorMessage.value="Needs > 6"
        }
    }


}

