package com.example.codebase.data.api

import com.example.codebase.data.model.Device
import com.example.codebase.data.model.GetDevicesResponse
import io.reactivex.Observable
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override fun getDevices(): Observable<GetDevicesResponse> = apiService.getDevices()


}