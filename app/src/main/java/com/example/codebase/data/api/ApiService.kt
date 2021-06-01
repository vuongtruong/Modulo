package com.example.codebase.data.api

import com.example.codebase.data.model.Device
import com.example.codebase.data.model.GetDevicesResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("modulotest/data.json")
    fun getDevices(): Observable<GetDevicesResponse>

}