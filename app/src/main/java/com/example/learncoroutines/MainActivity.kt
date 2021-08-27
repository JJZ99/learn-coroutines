package com.example.learncoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val TAG = "Coroutines"

    private val TAG_USER = "Coroutines User"
    private val TAG_FRIEND = "Coroutines Friend"
    private val TAG_FEED = "Coroutines Feed"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = this.findViewById<Button>(R.id.click_btn)
        btn.setOnClickListener {
            var user = "user"
            this.lifecycleScope.launch {
                 user =  getUserInfo()
            }
            Log.i(TAG_USER,user)
            var friendList = "friendList"

            this.lifecycleScope.async {
                friendList = getFriendList(user)
            }
            Log.i(TAG_FRIEND,friendList.toString())
            var feedList = "feedList"

            this.lifecycleScope.launch {
                feedList = getFeedList(friendList)
            }
            Log.i(TAG_FEED,feedList.toString())
        }



    }
    // delay(1000L)用于模拟网络请求

    //挂起函数
// ↓
    suspend fun getUserInfo(): String {
        withContext(Dispatchers.IO) {
            delay(1000L)
        }
        Log.i(TAG,"getUserInfo")

        return "BoyCoder"
    }
    //挂起函数
// ↓
    suspend fun getFriendList(user: String): String {
        withContext(Dispatchers.IO) {
            delay(1000L)
        }
        Log.i(TAG,"getFriendList")

        return "Tom, Jack"
    }
    //挂起函数
// ↓
    suspend fun getFeedList(list: String): String {
        withContext(Dispatchers.IO) {
            delay(1000L)
        }
        Log.i(TAG,"getFeedList")
        return "{FeedList..}"
    }
}