package com.vikas.doggoadoption.network

import com.vikas.doggoadoption.data.DoggoBreedResponseModel
import com.vikas.doggoadoption.data.DoggoResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface DoggoApiService {

    @GET("v1/images/search")
    suspend fun getDoggoImages(
        @Query("page") page: Int,
        @Query("limit") size: Int
    ): List<DoggoResponseModel>

    @GET("/v1/breeds?limit=15")
    suspend fun getBreeds(): List<DoggoBreedResponseModel>

    @GET("/v1/categories")
    suspend fun getCategories(): List<DoggoBreedResponseModel>

}