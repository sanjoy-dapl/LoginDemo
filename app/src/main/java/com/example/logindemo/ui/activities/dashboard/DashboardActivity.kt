package com.example.logindemo.ui.activities.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.logindemo.R
import com.example.logindemo.databinding.ActivityDashboardBinding
import com.example.logindemo.utilities.KEY_NAME
import org.koin.androidx.viewmodel.ext.android.getViewModel


class DashboardActivity : AppCompatActivity() {

    private lateinit var viewModel: DashboardViewModel
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)

        viewModel = getViewModel()

        val intent = intent

        val name = intent.getStringExtra(KEY_NAME)

        binding.tvUsername.text = name


        binding.viewmodel = viewModel

    }

}