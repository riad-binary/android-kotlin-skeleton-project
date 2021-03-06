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
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

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
        Log.e(TAG, "getPost")
        _networkState.postValue(NetworkState.LOADING)
        try {
            compositeDisposable.add(
                apiService.getPost()
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {
//                            Log.e(TAG, "getPost: " + Gson().toJson(it.body()))
                            Log.e(TAG, "getPost: " + it.body())
                        },
                        {
                            if (it is NoConnectivityException) {
                                _networkState.postValue(NetworkState.NO_CONNECTION)
                            } else {
                                _networkState.postValue(NetworkState.ERROR)
                            }
                        }
                    )
            )

        } catch (e: Exception) {
            e.message?.let { Log.e(TAG, it) }
        }

    }


}