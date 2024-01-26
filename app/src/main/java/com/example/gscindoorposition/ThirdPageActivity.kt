package com.example.gscindoorposition

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

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
    data class Person(val name: String, val age: Int, val userId: Int)

    fun OkHttpPostFun(view: View){
        println("Post by okhttp")
        // val jsonString = "{\"AAAAAA\":\"BBBBBB\",\"CCCCCCC\":\"DDDDDD\",\"EEEEEE\":\"FFFFFFF\",\"userId\":8}"
        val person = Person("John", 25, 15)
        val gson = Gson()
        val jsonString = gson.toJson(person)
        println("Object: $person")
        println("JSON: $jsonString")
        val JSON: MediaType = "application/json; charset=utf-8".toMediaType()
        val newProduct: RequestBody = jsonString.toRequestBody(JSON)
        val request = Request.Builder()
            .url("https://jsonplaceholder.typicode.com/posts")
            .post(newProduct)
            .build()

        GlobalScope.launch(Dispatchers.IO) {
            try{
                val response = client.newCall(request).execute()
                println(response.body?.string())
            } catch (e: Exception){
                e.printStackTrace()
            }

        }

    }

}