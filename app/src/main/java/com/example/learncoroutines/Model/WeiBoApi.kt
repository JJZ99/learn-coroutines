package com.example.abcdialogue.Weibo.Model


import com.example.learncoroutines.Model.DTO.WBAllDTO
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 微博请求接口
 */
interface WeiBoApi {

    /**
     * 获取国家列表
     */
    @GET(COUNTRY)
    fun getProvinceList(@Query("access_token") accessToken: String): Observable<List<Map<String,String>>>

    /**
     * 获取page的微博，每页15条
     * page 1.....
     */
    @GET(STATUES)
    fun getStatusesList(
        @Query("access_token") accessToken: String,
        @Query("page") page:Int,
        @Query("count") count: Int = 15,
        @Query("feature") feature: Int = 2
    ): Observable<WBAllDTO>

    companion object {
        const val COUNTRY = "https://api.weibo.com/2/common/get_country.json"
        const val STATUES = "https://api.weibo.com/2/statuses/home_timeline.json"
    }
}