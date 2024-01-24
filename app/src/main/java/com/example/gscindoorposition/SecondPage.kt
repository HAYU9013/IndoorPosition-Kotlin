package com.example.gscindoorposition

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecondPage : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private var isPlaying = false
    private var apiClient: ApiClient? = null
    private var getApi: GetApi? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_page)
        val playButton: Button = findViewById(R.id.playMusic)
        playButton.setOnClickListener {
            if (isPlaying) {
                // 如果正在播放，则停止播放
                stopPlaying()
            } else {
                // 如果没有播放，则开始播放
                startPlaying()
            }
        }

        val getDataButton: Button = findViewById(R.id.getfromweb)

        apiClient = ApiClient()
        getApi = apiClient!!.testWebData()!!.create(GetApi::class.java)
        getDataButton.setOnClickListener {
            println("getting data")
            val call: Call<DataResponse?>? = getApi?.getJsonData(5)

            call?.enqueue(object : Callback<DataResponse?> {
                override fun onResponse(call: Call<DataResponse?>, response: Response<DataResponse?>) {
                    var tmp: String = response.body()?.toString() ?: ""
                    println(tmp)
                }

                override fun onFailure(call: Call<DataResponse?>, t: Throwable) {
                    println("抓取失敗")
                }
            })
        }
    }
    private fun startPlaying() {
        // 检查媒体播放器是否为空并释放资源
        mediaPlayer?.release()
        // 创建新的媒体播放器
        mediaPlayer = MediaPlayer.create(this, R.raw.museum)
        // 跳转到 1:05（65秒）处
        mediaPlayer?.seekTo(65000)
        // 开始播放
        mediaPlayer?.start()

        isPlaying = true
    }

    private fun stopPlaying() {
        // 停止播放并释放媒体播放器资源
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null

        isPlaying = false
    }

    override fun onDestroy() {
        super.onDestroy()
        // 在Activity销毁时释放媒体播放器资源
        mediaPlayer?.release()
    }
}