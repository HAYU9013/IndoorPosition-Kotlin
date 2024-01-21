package com.example.gscindoorposition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var Gtext: TextView
    private lateinit var Gbtn: Button
    private var clickCnt = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Gtext = findViewById(R.id.Title)
    }

    fun ChangeGreetingText(view: View) {
        println("click"  + clickCnt.toString())
        clickCnt++
        Gtext.text = "click " + clickCnt.toString()
        Toast.makeText(this, clickCnt.toString(), Toast.LENGTH_LONG).show()

    }
}