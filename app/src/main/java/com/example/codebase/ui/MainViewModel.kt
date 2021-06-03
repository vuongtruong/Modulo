package com.example.codebase.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.codebase.base.BaseViewModel
import com.example.codebase.data.model.Device
import com.example.codebase.data.model.GetDevicesResponse
import com.example.codebase.data.respository.ApiRepository
import com.example.codebase.util.NetworkHelper
import com.example.codebase.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_main.*

@HiltViewModel
class MainViewModel @Inject constructor(private val apiRepository: ApiRepository, private val networkHelper: NetworkHelper) : BaseViewModel() {

    var listDevices = MutableLiveData<GetDevicesResponse>()

    fun fetchDevices() {
        if (networkHelper.isNetworkConnected()) {
            addCompositeDisposable(apiRepository.getDevices().subscribeWith(object : DisposableObserver<GetDevicesResponse>() {
                override fun onNext(value: GetDevicesResponse?) {
                    Log.d("MainViewModel", "$value")
                    listDevices.postValue(value)
                }

                override fun onError(e: Throwable?) {
                    e?.printStackTrace()

                }

                override fun onComplete() {
                }

            }))
        }
    }


    fun getDevices(): MutableLiveData<GetDevicesResponse> {
        return listDevices
    }

}