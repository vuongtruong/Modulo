package com.example.codebase.ui

import com.example.codebase.data.model.Device

interface IDeviceCallback {
    fun onItemClick(position: Int, device: Device)
}