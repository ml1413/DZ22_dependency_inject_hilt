package com.example.dz22_dependency_inject_hilt.Response

import com.example.dz22_dependency_inject_hilt.model.ResponseModel
import retrofit2.Response

class Repository(private val retrofit: ApiClient) {
    suspend fun getCryptoByName(name: String): Response<ResponseModel> {
        val apiInterface = retrofit.client.create(ApiInterface::class.java)
        return apiInterface.getCryptoByName(name = name)
    }
}