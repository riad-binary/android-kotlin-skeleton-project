package biz.shopup.shimamura.data.api

import com.inforich.android_kotlin_skeleton_project.data.api.ApiEndPoints
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.*

interface ApiInterface {

    @GET(ApiEndPoints.POST)
    fun getPost(): Single<ResponseBody>

}