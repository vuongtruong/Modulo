package com.example.codebase.data.api

import com.example.codebase.data.model.Device
import com.example.codebase.data.model.GetDevicesResponse
import io.reactivex.Observable

interface ApiHelper {
    fun getDevices(): Observable<GetDevicesResponse>
}