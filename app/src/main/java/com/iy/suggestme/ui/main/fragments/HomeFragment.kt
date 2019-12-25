package com.iy.suggestme.ui.main.fragments

import android.content.Context
import androidx.fragment.app.Fragment
import com.iy.suggestme.utils.LiveDataCommunicator

class HomeFragment: Fragment() {


    companion object{
        lateinit var ctx:Context
    }
    private var communicator:LiveDataCommunicator?=null

}