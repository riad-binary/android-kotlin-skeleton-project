package com.inforich.android_kotlin_skeleton_project.views.activity

import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import biz.shopup.shimamura.data.api.NetworkState
import com.inforich.android_kotlin_skeleton_project.R
import com.inforich.android_kotlin_skeleton_project.base.BaseDataBindingActivity
import com.inforich.android_kotlin_skeleton_project.databinding.ActivityMainBinding
import com.inforich.android_kotlin_skeleton_project.viewmodels.MainViewModel
import com.inforich.android_kotlin_skeleton_project.views.adapter.PostListAdapter

class MainActivity : BaseDataBindingActivity<ActivityMainBinding, MainViewModel>() {
    private val TAG: String = MainActivity::class.java.getName()
    private lateinit var mViewModel: MainViewModel

    private lateinit var  postListAdapter: PostListAdapter


    override val layoutId: Int
        get() = R.layout.activity_main

    override val bindingVariable: Int
        get() = com.inforich.android_kotlin_skeleton_project.BR.viewModel

    override val viewModel: MainViewModel
    get (){
//        viewDataBinding!!.lifecycleOwner = this
        mViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mViewModel.init()
        return mViewModel as MainViewModel
    }

    override fun initView() {
        Log.e(TAG, "initView")

        viewDataBinding.recyclerView.layoutManager = GridLayoutManager(applicationContext,2)
        postListAdapter = PostListAdapter(applicationContext)
        viewDataBinding.recyclerView.adapter = postListAdapter

        mViewModel.getPost()

        mViewModel.postList.observe(this, Observer {
            Log.d(TAG, "postList: " + it.toString())
            postListAdapter.setDataList(it)

        })

        mViewModel.networkState.observe(this, Observer {
            Log.d(TAG, it.toString())
            if(it != NetworkState.LOADING){

            } else {

            }
        })




    }

}
