package com.hkq.use_hilt.di.module

import com.hkq.use_hilt.di.AnalyticsService
import com.hkq.use_hilt.di.anno.AuthInterceptorOkHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * 有时，类型不能通过构造函数注入。发生这种情况可能有多种原因。例如，您不能通过构造函数注入接口。此外，您也不
 * 能通过构造函数注入不归您所有的类型，如来自外部库的类。在这些情况下，您可以使用 Hilt 模块向 Hilt 提供绑定信息。
 * Hilt 模块是一个带有 @Module 注释的类。与 Dagger 模块一样，它会告知 Hilt 如何提供某些类型的实例。
 * 与Dagger 模块不同的是，您必须使用 @InstallIn 为 Hilt 模块添加注释，以告知 Hilt 每个模块将用在或安装在哪个 Android 类中。
 */
@Module
@InstallIn(ApplicationComponent::class)//使用单例需要安装在ApplicationComponent中，而不是ActivityComponent，并且需要在@Provides前加@Singleton
object AnalyticsSingletonModule2 {

    //情形二：使用 @Provides 注入实例
    //接口不是无法通过构造函数注入类型的唯一一种情况。如果某个类不归您所有（因为它来自外部库，如 Retrofit、OkHttpClient 或 Room 数据库等类），
    //或者必须使用构建器模式创建实例，也无法通过构造函数注入。
    @Singleton
    @Provides
    fun provideAnalyticsService(
        @AuthInterceptorOkHttpClient okHttpClient: OkHttpClient
    ): AnalyticsService {
        return Retrofit.Builder()
            .baseUrl("https://example.com")
            .client(okHttpClient)
            .build()
            .create(AnalyticsService::class.java)
    }

}