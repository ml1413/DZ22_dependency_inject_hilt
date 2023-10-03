package com.example.dz22_dependency_inject_hilt.model

data class ResponseModel(
    val data: Data?
)

data class Data(
    val id: String,
    val symbol: String,
    val rateUsd: String,
)
