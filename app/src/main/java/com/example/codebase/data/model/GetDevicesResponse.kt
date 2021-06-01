package com.example.codebase.data.model

import com.squareup.moshi.Json

data class GetDevicesResponse(
    @Json(name = "devices")
    var devices: MutableList<Device>
)