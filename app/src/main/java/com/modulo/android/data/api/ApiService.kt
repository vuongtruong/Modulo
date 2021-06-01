package com.modulo.android.data.api

import com.modulo.android.data.model.User
import io.reactivex.Single

interface ApiService {

    fun getUsers(): Single<List<User>>

}