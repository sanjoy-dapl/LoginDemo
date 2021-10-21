package com.example.logindemo.ui.activities.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.logindemo.utilities.Screens
import java.util.*
import kotlin.concurrent.schedule

class SplashViewModel : ViewModel() {

    val _loadingState = MutableLiveData<Int>()

    fun startTimer() {
        Timer("SettingUp", false).schedule(2000) {
            onTimerComleted()
        }
    }

    private fun onTimerComleted() {

            _loadingState.postValue(Screens.LOGIN.ordinal)

    }

}