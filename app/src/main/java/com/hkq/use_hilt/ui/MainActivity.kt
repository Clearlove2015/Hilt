package com.hkq.use_hilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hkq.use_hilt.R
import com.hkq.use_hilt.di.AnalyticsAdapter
import com.hkq.use_hilt.di.anno.AuthInterceptorOkHttpClient
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.OkHttpClient
import javax.inject.Inject

/**
 * https://developer.android.com/training/dependency-injection/hilt-android#kotlin
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //从组件获取依赖项
    @Inject
    lateinit var analytics: AnalyticsAdapter

    @AuthInterceptorOkHttpClient
    @Inject
    lateinit var okHttpClient: OkHttpClient;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
