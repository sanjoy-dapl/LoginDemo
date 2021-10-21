package com.example.logindemo.ui.activities.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.logindemo.R
import com.example.logindemo.databinding.ActivityLoginBinding
import com.example.logindemo.ui.activities.dashboard.DashboardActivity
import com.example.logindemo.utilities.KEY_NAME
import com.example.logindemo.utilities.Screens
import org.koin.androidx.viewmodel.ext.android.getViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        viewModel = getViewModel()

        binding.etUserName.addTextChangedListener(textWatcherTitle)
        binding.etPassword.addTextChangedListener(textWatcherTitle)


        viewModel._loadingScreen.observe(this, Observer {
            when (it) {

                Screens.DASHBOARD.ordinal -> {
                    val intent = Intent(this, DashboardActivity::class.java)
                    intent.putExtra(KEY_NAME, viewModel.strUserLogin.value)
                    startActivity(intent)
                    finish()
                }
            }
        })

        binding.viewmodel = viewModel

    }

    private val textWatcherTitle = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            viewModel.validation()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }
    }
}

