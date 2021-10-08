package com.example.learncoroutines.code

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
    GlobalScope.launch(Dispatchers.Default) {
        //delay(1000)
        println("GlobalScope main start")
        var str = withContext(Dispatchers.IO){
            delay(2000)
            getString("withContext")
        }
        println(str)
        launch {
            delay(1500)
            getString2("launch")
        }

        println("wait")
        delay(1000)
        println("jj")
    }

    println("main end")
    Thread.sleep(5500)
    println("main over")
}

suspend fun getString2(string: String): String {
    println("${string} delay 1500 then return response")
    return "resposne data"
}
suspend fun getString(string: String): String {
    println("${string} delay 2000 then return response")
    return "resposne data"
}

fun getUser(string: String): String = string

