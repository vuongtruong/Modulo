package com.example.codebase.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.codebase.BR
import com.example.codebase.R
import com.example.codebase.base.BaseActivity
import com.example.codebase.ui.MainAdapter
import com.example.codebase.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codebase.data.model.Device
import com.example.codebase.util.Status
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.DriverManager.println

@AndroidEntryPoint
class MainActivity : BaseActivity< MainViewModel>() {

    private lateinit var adapter: MainAdapter

    override val layoutId: Int
        get() = R.layout.activity_main

//    override val bindingVariable: Int
//        get() = BR.viewModel

    override val viewModel: MainViewModel by viewModels()

    override fun initView() {
        viewModel.fetchDevices()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupObserver()
    }

    override fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(this,arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    override fun setupObserver() {
        viewModel.getDevices().observe(this, Observer {
            if(!it.devices.isEmpty()) {
                progressBar.visibility = View.GONE
                renderList(it.devices)
                recyclerView.visibility = View.VISIBLE
            }

        })
    }

    private fun renderList(devices: List<Device>) {
        adapter.addData(devices)
        adapter.notifyDataSetChanged()
    }

}

