package com.hkq.use_hilt.di.module

import com.hkq.use_hilt.di.anno.AuthInterceptorOkHttpClient
import com.hkq.use_hilt.di.anno.OtherInterceptorOkHttpClient
import com.hkq.use_hilt.interceptor.AuthInterceptor
import com.hkq.use_hilt.interceptor.OtherInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient

/**
 * 为同一类型提供多个绑定
 * 如果您需要让 Hilt 以依赖项的形式提供同一类型的不同实现，必须向 Hilt 提供多个绑定。您可以使用限定符为同一类型定义多个绑定。
 * 限定符是一种注释，当为某个类型定义了多个绑定时，您可以使用它来标识该类型的特定绑定。
 * 仍然接着前面的例子来讲。如果需要拦截对 AnalyticsService 的调用，您可以使用带有拦截器的 OkHttpClient 对象。
 * 对于其他服务，您可能需要以不同的方式拦截调用。在这种情况下，您需要告知 Hilt 如何提供两种不同的 OkHttpClient 实现。
 */
@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @AuthInterceptorOkHttpClient
    @Provides
    fun provideAuthInterceptorOkHttpClient(
        authInterceptor: AuthInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()
    }

    @OtherInterceptorOkHttpClient
    @Provides
    fun provideOtherInterceptorOkHttpClient(
        otherInterceptor: OtherInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(otherInterceptor)
            .build()
    }
}