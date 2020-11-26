package com.hkq.use_hilt.di

import com.hkq.use_hilt.di.anno.AuthInterceptorOkHttpClient
import okhttp3.OkHttpClient
import javax.inject.Inject

class ExampleServiceImpl @Inject constructor(
    @AuthInterceptorOkHttpClient private val okHttpClient: OkHttpClient
) {

}