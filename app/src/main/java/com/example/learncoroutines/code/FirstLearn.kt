package com.example.learncoroutines.code

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() {
//    val start = System.currentTimeMillis()
//    runBlocking {
//        repeat(100000) {
//            launch {
//                print(".")
//            }
//        } }
//    val end = System.currentTimeMillis()
//    println("\n协程"+(end - start))
//    val start2 = System.currentTimeMillis()
//        repeat(100000) {
//            Thread{
//                print(".")
//            }.start()
//        }
//    val end2 = System.currentTimeMillis()
//    println("\n线程"+(end2 - start2))
    println("main start")
    GlobalScope.launch {
        val result = getString()
        println("wait")
        println(result)
    }

    Thread.sleep(3000)
    println("main end")

}
suspend fun getString(): String {
    delay(2000)
    println("delay 2000 then return response")
    return "resposne data"
}