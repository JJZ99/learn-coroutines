
package com.example.learncoroutines.Bean

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * demo测试用的类
 */
data class CountryBean(
    val statusCode: String,
    val statusMsg: String?,
):Serializable
