package com.example.logindemo.app.di

import com.example.logindemo.ui.activities.dashboard.DashboardViewModel
import com.example.logindemo.ui.activities.login.LoginViewModel
import com.example.logindemo.ui.activities.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel() }
    viewModel { LoginViewModel() }
    viewModel { DashboardViewModel() }


}