package com.example.codebase.data.model

import com.squareup.moshi.Json

data class Device(
    @Json(name = "id")
    var id: String,

    @Json(name = "deviceName")
    var deviceName: String,

    @Json(name = "productType")
    var productType: String
)