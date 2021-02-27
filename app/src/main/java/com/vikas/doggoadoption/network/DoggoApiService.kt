package com.vikas.doggoadoption.network

import com.vikas.doggoadoption.data.DoggoResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface DoggoApiService {

    @GET("v1/images/search")
    suspend fun getDoggoImages(
        @Query("page") page: Int,
        @Query("limit") size: Int
    ): List<DoggoResponseModel>

}