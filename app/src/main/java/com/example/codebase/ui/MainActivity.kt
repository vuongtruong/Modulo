package com.example.codebase.ui

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.codebase.BR
import com.example.codebase.R
import com.example.codebase.base.BaseActivity
import com.example.codebase.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutId: Int
        get() = R.layout.activity_main

    override val bindingVariable: Int
        get() = BR.viewModel

    override val viewModel: MainViewModel by viewModels()

    override fun initView() {
        viewModel.getDevice()
    }

    override fun setupObserver() {
        viewModel.listDevices.observe(this, Observer {
            viewDataBinding?.txt?.text  = it.toString()
        })
    }

}