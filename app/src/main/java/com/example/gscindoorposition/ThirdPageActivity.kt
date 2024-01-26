package com.example.gscindoorposition

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.Request

class ThirdPageActivity : AppCompatActivity() {

    val client = OkHttpClient.Builder().build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_page)
    }

    fun OkHttpGetFun(view: View){
        println("ok http get")
        GlobalScope.launch(Dispatchers.IO) {
            val request = Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts")
                .build()
            try{
                val response = client.newCall(request).execute()
                println(response.body?.string())
            } catch (e: Exception){
                e.printStackTrace()
            }

        }

    }

}