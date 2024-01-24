package com.example.gscindoorposition

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
class ApiClient {
    fun testWebData(): Retrofit? {
        return Retrofit.Builder() //建立Retrofit
            .baseUrl("https://jsonplaceholder.typicode.com/") //輸入Api資料網站
            .addConverterFactory(GsonConverterFactory.create()) //添加Gson轉換器，這個幫助我們將http上的資料轉成Retrofit能夠處理的Json數據並將其轉換為Java對象
            .build()
        //將環境建立起來
    }

}