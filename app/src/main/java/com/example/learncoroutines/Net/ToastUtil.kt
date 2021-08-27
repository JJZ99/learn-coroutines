package com.example.learncoroutines.Net

import android.content.Context
import android.widget.Toast
import com.example.learncoroutines.MyApplication

object ToastUtil {


    /**
     * 显示长时间，不太用。。。
     */
    fun Any.toastLong(context: Context = MyApplication.context, duration: Int = Toast.LENGTH_LONG): Toast {
        return Toast.makeText(context, this.toString(), duration).apply { show() }
    }
    /**
     * 显示短，不太用。。。
     */
    fun Any.toastShort(context: Context = MyApplication.context, duration: Int = Toast.LENGTH_SHORT): Toast {
        return Toast.makeText(context, this.toString(), duration).apply { show() }
    }

    //或者也可以这样，用Context调用
    fun Context.toast(content: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, content, duration).apply {
            show()
        }
    }


}