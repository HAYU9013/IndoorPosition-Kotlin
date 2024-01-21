package com.example.gscindoorposition

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var handler: Handler
    private lateinit var runnable: Runnable

    private lateinit var TestTopic: TextView
    private lateinit var Testbtn: Button
    private var clickCnt = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TestTopic = findViewById(R.id.Title)
        Testbtn = findViewById(R.id.StatusBtn)

        handler = Handler()
        runnable = object : Runnable {
            override fun run() {
                // 在这里执行需要定期执行的任务
                // 例如：在控制台打印一条消息
                println("任务执行时间: ${System.currentTimeMillis()}")

                // 重复执行该任务，间隔为五秒
                handler.postDelayed(this, 500)
            }
        }
        handler.post(runnable)

    }

    fun ChangeGreetingText(view: View) {
        println("click"  + clickCnt.toString())
        clickCnt++
        TestTopic.text = "click " + clickCnt.toString()
        // Toast.makeText(this, clickCnt.toString(), Toast.LENGTH_LONG).show()

    }
    override fun onDestroy() {
        // 移除所有未执行的任务，以防止内存泄漏
        handler.removeCallbacks(runnable)
        super.onDestroy()
    }
}