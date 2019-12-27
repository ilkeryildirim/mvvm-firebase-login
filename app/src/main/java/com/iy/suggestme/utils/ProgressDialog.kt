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

        return mProgressDialog
    }
}
