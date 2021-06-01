package com.example.codebase.data.respository

import com.example.codebase.data.api.ApiHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiHelper: ApiHelper) {

    fun getDevices() = apiHelper.getDevices().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

}