package biz.shopup.shimamura.data.api

import com.inforich.android_kotlin_skeleton_project.data.api.ApiEndPoints
import com.inforich.android_kotlin_skeleton_project.data.models.RssFeed
import com.inforich.android_kotlin_skeleton_project.data.models.RssFeed3
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {

    @GET(ApiEndPoints.POST)
    fun getPost(): Single<ResponseBody>

}