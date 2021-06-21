package com.inforich.android_kotlin_skeleton_project.data.api

import com.inforich.android_kotlin_skeleton_project.BuildConfig

class ApiEndPoints {

    companion object {
        const val BASE_URL = BuildConfig.BASE_URL

        const val POST = "photos_public.gne" // https://www.flickr.com/services/feeds/photos_public.gne
    }
}