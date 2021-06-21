package com.inforich.android_kotlin_skeleton_project.views.activity

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.inforich.android_kotlin_skeleton_project.R
import com.inforich.android_kotlin_skeleton_project.base.BaseDataBindingActivity
import com.inforich.android_kotlin_skeleton_project.databinding.ActivityMainBinding
import com.inforich.android_kotlin_skeleton_project.viewmodels.MainViewModel

class MainActivity : BaseDataBindingActivity<ActivityMainBinding, MainViewModel>() {
    private val TAG: String = MainActivity::class.java.getName()
    private lateinit var mViewModel: MainViewModel

    override val layoutId: Int
        get() = R.layout.activity_main

    override val bindingVariable: Int
        get() = com.inforich.android_kotlin_skeleton_project.BR.viewModel

    override val viewModel: MainViewModel
    get (){
        viewDataBinding!!.lifecycleOwner = this
        mViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mViewModel.init()
        return mViewModel as MainViewModel
    }

    override fun initView() {
        Log.e(TAG, "initView")

        mViewModel.getPost()
    }

}
