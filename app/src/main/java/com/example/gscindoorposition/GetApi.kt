package com.example.gscindoorposition

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path // Import the @Path annotation
interface GetApi {
    @GET("albums/{id}")
    fun getJsonData(@Path("id") id: Int): Call<DataResponse?>?
    //用Path將傳入的id填入{}裡面
}