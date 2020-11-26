package com.hkq.use_hilt.di.module

import com.hkq.use_hilt.di.AnalyticsService
import com.hkq.use_hilt.di.AnalyticsServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * 有时，类型不能通过构造函数注入。发生这种情况可能有多种原因。例如，您不能通过构造函数注入接口。此外，您也不
 * 能通过构造函数注入不归您所有的类型，如来自外部库的类。在这些情况下，您可以使用 Hilt 模块向 Hilt 提供绑定信息。
 * Hilt 模块是一个带有 @Module 注释的类。与 Dagger 模块一样，它会告知 Hilt 如何提供某些类型的实例。
 * 与Dagger 模块不同的是，您必须使用 @InstallIn 为 Hilt 模块添加注释，以告知 Hilt 每个模块将用在或安装在哪个 Android 类中。
 */

/**
 * Hilt 提供了以下组件：
 * Hilt 组件	注入器面向的对象
 * ApplicationComponent	Application
 * ActivityRetainedComponent	ViewModel
 * ActivityComponent	Activity
 * FragmentComponent	Fragment
 * ViewComponent	View
 * ViewWithFragmentComponent	带有 @WithFragmentBindings 注释的 View
 * ServiceComponent	Service
 * 注意：Hilt 不会为广播接收器生成组件，因为 Hilt 直接从 ApplicationComponent 注入广播接收器。
 */
@Module
@InstallIn(ApplicationComponent::class)//使用单例需要安装在ApplicationComponent中，而不是ActivityComponent，并且需要在@Binds前加@Singleton
abstract class AnalyticsSingletonModule {

    //情形一：使用 @Binds 注入接口实例
    //如果 AnalyticsService 是一个接口，则您无法通过构造函数注入它，而应向 Hilt 提供绑定信息，方法是在 Hilt 模块内创建一个带有 @Binds 注释的抽象函数。
    @Singleton
    @Binds
    abstract fun bindAnalyticsService(
        analyticsServiceImpl: AnalyticsServiceImpl
    ): AnalyticsService

}