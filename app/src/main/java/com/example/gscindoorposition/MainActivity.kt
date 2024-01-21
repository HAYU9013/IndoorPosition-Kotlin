package com.example.gscindoorposition

import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.View
import android.widget.Button
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView
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

        // 创建 GridLayout 并添加 ImageView
        setupGridLayout()


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
    // 封装添加 ImageView 到 GridLayout 的函数
    private fun setupGridLayout() {
        // 获取 GridLayout
        val gridLayout: GridLayout = findViewById(R.id.gridLayout)
        println("get grid")
        val amount: Int = 100
        for(i in 1 until amount){
            for(j in 1 until amount){
                val imageView = createImageView(R.drawable.location, i, j, 1000/amount)
                gridLayout.addView(imageView)
                println("img " + i.toString() + " " + j.toString())
            }
        }
    }
    // 创建 ImageView 并设置布局参数的辅助函数
    private fun createImageView(imageResId: Int, column: Int, row: Int, imgSize: Int): ImageView {
        val imageView = ImageView(this)
        val params = GridLayout.LayoutParams().apply {
            width = imgSize
            height = imgSize
            setGravity(Gravity.FILL)
            columnSpec = GridLayout.spec(column)
            rowSpec = GridLayout.spec(row)
        }
        imageView.layoutParams = params
        imageView.setImageResource(imageResId)
        return imageView
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