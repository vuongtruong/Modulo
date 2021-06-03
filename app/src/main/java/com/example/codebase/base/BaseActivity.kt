package com.example.codebase.base

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.example.codebase.R
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

abstract class BaseActivity< V : BaseViewModel> : AppCompatActivity() {

    var moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @get:LayoutRes
    abstract val layoutId: Int

//    abstract val bindingVariable: Int
//    var viewDataBinding: T? = null
//        private set

    /**
     * Get ViewModel with this activity
     *
     * @return ViewModel instance
     */
    abstract val viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        viewModel.onViewCreated()
        //performDataBinding()
        setupUI()
        initView()
        setupErrorWatcher()
//        setupObserver()
    }

//    private fun performDataBinding() {
//        viewDataBinding = DataBindingUtil.setContentView(this, layoutId)
//        viewDataBinding!!.lifecycleOwner = this
//        viewDataBinding!!.setVariable(bindingVariable, viewModel)
//        viewDataBinding!!.executePendingBindings()
//    }

    /**
     * Init default view
     */
    abstract fun initView()

    /**
     * Setup all Observer
     */
    abstract fun setupObserver()

    abstract fun setupUI()

    private fun setupErrorWatcher() {
        viewModel.errorDialogWatcher.observe(this, Observer {
            showAlertDialog(getString(R.string.app_name), it)
        })

        viewModel.errorToastyWatcher.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }

    protected fun showAlertDialog(title: Int, message: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message).setTitle(title)
        val dialog = builder.create()
        dialog.show()
    }

    protected fun showAlertDialog(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message).setTitle(title)
        val dialog = builder.create()
        dialog.show()
    }

}