package com.example.abcdialogue.Weibo.Model


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learncoroutines.Bean.CountryBean
import com.example.learncoroutines.Bean.WBStatusBean
import com.example.learncoroutines.Model.DTO.WBAllDTO
import com.example.learncoroutines.Model.DTO.transformToBean
import com.example.learncoroutines.Net.ToastUtil.toastShort

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class WBViewModel : ViewModel(){


    val countryList = MutableLiveData<List<CountryBean>>()
    val statusList = MutableLiveData<MutableList<WBStatusBean>>(mutableListOf<WBStatusBean>())
    //也可以参考CommentViewModel。kt 140的写法
    fun getProvinceList(token: String) {
        DataFetchModel.getProvinceList(token)
            .subscribe(object : Observer<List<Map<String, String>>> {
                override fun onComplete() {}
                override fun onSubscribe(d: Disposable) {
                }
                override fun onNext(t: List<Map<String, String>>) {
                    Log.i("https:", t.toString())
                    val list = mutableListOf<CountryBean>()
                    for (i in t.indices) {
                        list.add(CountryBean(t[i].keys.first(), t[i].values.first()))
                    }
                    countryList.value = list
                }
                override fun onError(e: Throwable) {
                    "城市数据请求失败".toastShort()
                    e.printStackTrace()
                }
            })
    }

    fun getStatusesList(token:String,page:Int){
        Log.i("页数","===============$page===============")
        //"=======第{$page}页======".toastInfo()
        DataFetchModel.getStatusesList(token,page)
            .subscribe(object : Observer<WBAllDTO> {
                override fun onComplete() {
                    "微博数据请求成功".toastShort()
                }
                override fun onSubscribe(d: Disposable) {
                }
                override fun onNext(resp: WBAllDTO) {
                        statusList.value = statusList.value?.apply {
                            addAll(resp.statuses?.map { dto ->
                                dto.transformToBean()
                            } ?: listOf())
                        }

                    Log.i("get statueslist:", statusList.value.toString())
                }
                override fun onError(e: Throwable) {
                    "微博数据请求失败".toastShort()
                    e.printStackTrace()
                }
            })
    }


    override fun onCleared() {
        super.onCleared()
    }
}