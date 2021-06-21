package com.inforich.android_kotlin_skeleton_project.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import biz.shopup.shimamura.data.api.ApiClient
import biz.shopup.shimamura.data.api.ApiInterface
import biz.shopup.shimamura.data.api.NetworkState
import com.google.gson.Gson
import com.inforich.android_kotlin_skeleton_project.App
import com.inforich.android_kotlin_skeleton_project.base.BaseViewModel
import com.inforich.android_kotlin_skeleton_project.utils.NoConnectivityException
import com.inforich.android_kotlin_skeleton_project.utils.XmlParser
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.nio.charset.StandardCharsets

class MainViewModel: BaseViewModel() {
    private val TAG: String = MainViewModel::class.java.getName()

    val apiService : ApiInterface = ApiClient.getClient(App.instance)
    private val compositeDisposable = CompositeDisposable()

    private val _networkState  = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = _networkState


    fun init() {
        Log.e(TAG, "MainViewModel init")
    }

    fun getPost() {
        Log.e(TAG, "getPost()")
        _networkState.postValue(NetworkState.LOADING)
            compositeDisposable.add(
                apiService.getPost()
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {
                            try{
                                val inputString: String = it.string()
                                val stream: InputStream =
                                    ByteArrayInputStream(inputString.toByteArray(StandardCharsets.UTF_8))
                                val list = XmlParser().parse(stream)
                                 Log.e(TAG, "getPost: " + Gson().toJson(list))

                            } catch (e: Exception){
                                Log.e(TAG, "getPost error: " +e.message)
                            }



                        },
                        {
                            if (it is NoConnectivityException) {
                                _networkState.postValue(NetworkState.NO_CONNECTION)
                            } else {
                                _networkState.postValue(NetworkState.ERROR)
                                Log.e(TAG, "getPost error: " + it.message)
                            }
                        }
                    )
            )


    }

}