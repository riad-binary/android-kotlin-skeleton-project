package com.inforich.android_kotlin_skeleton_project.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import biz.shopup.shimamura.data.api.ApiClient
import biz.shopup.shimamura.data.api.ApiInterface
import biz.shopup.shimamura.data.api.NetworkState
import com.google.gson.Gson
import com.inforich.android_kotlin_skeleton_project.App
import com.inforich.android_kotlin_skeleton_project.base.BaseViewModel
import com.inforich.android_kotlin_skeleton_project.data.models.Post
import com.inforich.android_kotlin_skeleton_project.utils.NoConnectivityException
import com.inforich.android_kotlin_skeleton_project.utils.XmlParser
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.nio.charset.StandardCharsets
import java.util.*

class MainViewModel: BaseViewModel() {
    private val TAG: String = MainViewModel::class.java.getName()

    val apiService : ApiInterface = ApiClient.getClient(App.instance)
    private val compositeDisposable = CompositeDisposable()

    val networkState  = MutableLiveData<NetworkState>()

    val postList =  MutableLiveData<List<Post>>()


    fun init() {
        Log.e(TAG, "MainViewModel init")
    }

    fun getPost() {
        Log.e(TAG, "getPost()")
        networkState.postValue(NetworkState.LOADING)
            compositeDisposable.add(
                apiService.getPost()
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {
                            val inputString: String = it.string()
                            val stream: InputStream =
                                ByteArrayInputStream(inputString.toByteArray(StandardCharsets.UTF_8))
                            val list = XmlParser().parse(stream)
                            val filterList: MutableList<Post> = mutableListOf<Post>()
                            for(item in list){
                                if(item.link != null && (item.link.contains(".jpg") || item.link.contains(".png"))){
                                    filterList.add(item)
                                }
                            }
                            postList.postValue(filterList)
//                             Log.e(TAG, "getPost: " + Gson().toJson(postList.value))
                            networkState.postValue(NetworkState.LOADED)
                        },
                        {
                            if (it is NoConnectivityException) {
                                networkState.postValue(NetworkState.NO_CONNECTION)
                            } else {
                                networkState.postValue(NetworkState.ERROR)
                                Log.e(TAG, "getPost error: " + it.message)
                            }
                        }
                    )
            )


    }

}