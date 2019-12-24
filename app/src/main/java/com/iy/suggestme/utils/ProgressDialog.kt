package com.iy.suggestme.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable

import android.view.Window

import com.iy.suggestme.R

class ProgressDialog {
     fun getProgressDialog(context: Context): Dialog {

        val mProgressDialog = Dialog(context)
        mProgressDialog.apply {
            window?.let {
                it.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                it.requestFeature(Window.FEATURE_NO_TITLE)
            }
            setContentView(R.layout.progress_dialog)
            setCancelable(true)
            setCanceledOnTouchOutside(false)
        }
        return mProgressDialog
    }
}
