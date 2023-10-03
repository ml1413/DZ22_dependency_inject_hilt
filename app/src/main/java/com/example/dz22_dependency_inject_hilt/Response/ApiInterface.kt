package com.example.dz22_dependency_inject_hilt.Response

import com.example.dz22_dependency_inject_hilt.model.ResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/v2/rates/{cryptoName}")
    suspend fun getCryptoByName(
        @Path("cryptoName") name: String
    ): Response<ResponseModel>
}