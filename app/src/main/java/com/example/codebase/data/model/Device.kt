package com.example.codebase.data.model

import com.squareup.moshi.Json

data class Device(
    @Json(name = "id")
    var id: Int,

    @Json(name = "deviceName")
    var deviceName: String,

    @Json(name = "productType")
    var productType: String,

    @Json(name = "model")
    val model: String = "",

    @Json(name = "intensity")
    val intensity: Int = 0,

    @Json(name = "position")
    val position: Int = 0,

    @Json(name = "temperature")
    val temperature: Int = 0
)