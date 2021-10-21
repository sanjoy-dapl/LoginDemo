package com.example.logindemo.ui.activities.login

import android.text.TextUtils
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.logindemo.R
import com.example.logindemo.utilities.Screens
import java.util.regex.Matcher
import java.util.regex.Pattern


class LoginViewModel : ViewModel() {

    val strUserLogin = MutableLiveData<String>()
    val strpassword = MutableLiveData<String>()

    val _loadingScreen = MutableLiveData<Int>()
    val UsernameTextVisibility: MutableLiveData<Int> = MutableLiveData()
    val PasswordTextVisibility: MutableLiveData<Int> = MutableLiveData()
    val BackgroundColor: MutableLiveData<Int> = MutableLiveData()
    val usernameErrorMessage: MutableLiveData<String> = MutableLiveData()
    val passwordErrorMessage: MutableLiveData<String> = MutableLiveData()
    val loginbuttonenable = MutableLiveData<Boolean>()

    fun callLogin() {

        _loadingScreen.postValue(Screens.DASHBOARD.ordinal)

    }

    private fun isValidUserName(username: String?): Boolean {
        val pattern: Pattern
        val USERNAME_PATTERN =
            "^[a-zA-Z0-9]{1,30}$"
        pattern = Pattern.compile(USERNAME_PATTERN)
        val matcher: Matcher = pattern.matcher(username)
        return matcher.matches()
    }


    private fun isValidPassword(password: String?): Boolean {
        val pattern: Pattern
        val PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@,!,?,_])(?=\\S+$).{6,15}$"
        pattern = Pattern.compile(PASSWORD_PATTERN)
        val matcher: Matcher = pattern.matcher(password)
        return matcher.matches()

    }

    /**
     *
     */
    fun validation() {
        var isValidate = true
        if (!TextUtils.isEmpty(strUserLogin.value) && !TextUtils.isEmpty(strpassword.value)) {
            if (!isValidUserName(strUserLogin.value)) {
                usernameErrorMessage.value = "Enter proper username"
                UsernameTextVisibility.value = View.VISIBLE
                isValidate = false
            }else{
                UsernameTextVisibility.value = View.GONE
            }

            if (!isValidPassword(strpassword.value) || strpassword.value?.length!! < 5) {
                passwordErrorMessage.value = "Password not meeting the criteria"
                PasswordTextVisibility.value = View.VISIBLE
                isValidate = false
            }else{
                PasswordTextVisibility.value = View.GONE
            }
        } else {
            UsernameTextVisibility.value = View.GONE
            PasswordTextVisibility.value = View.GONE
            isValidate = false
        }

        if(isValidate){
            BackgroundColor.value = R.color.colorButton
        }else{
            BackgroundColor.value = R.color.colorInactiveGrayButton
        }
        loginbuttonenable.value = isValidate

    }
}



