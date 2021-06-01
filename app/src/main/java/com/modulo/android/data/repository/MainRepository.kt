package com.modulo.android.data.repository

import com.modulo.android.data.api.ApiHelper
import com.modulo.android.data.model.User
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {

    fun getUsers(): Single<List<User>>{
        return apiHelper.getUsers()
    }
}