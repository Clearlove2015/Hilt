package com.hkq.use_hilt.di

import android.content.Context
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

//向 Hilt 提供绑定信息的一种方法是构造函数注入。在某个类的构造函数中使用 @Inject 注释，以告知 Hilt 如何提供该类的实例
//Hilt 提供了一些预定义的限定符。例如，由于您可能需要来自应用或 Activity 的 Context 类，因此 Hilt 提供了 @ApplicationContext 和 @ActivityContext 限定符

/**
 * 组件作用域
 * 默认情况下，Hilt 中的所有绑定都未限定作用域。这意味着，每当应用请求绑定时，Hilt 都会创建所需类型的一个新实例。
 * 在本例中，每当 Hilt 提供 AnalyticsAdapter 作为其他类型的依赖项或通过字段注入提供它（如在 ExampleActivity 中）时，Hilt 都会提供 AnalyticsAdapter 的一个新实例。
 * 不过，Hilt 也允许将绑定的作用域限定为特定组件。Hilt 只为绑定作用域限定到的组件的每个实例创建一次限定作用域的绑定，对该绑定的所有请求共享同一实例。
 * 下表列出了生成的每个组件的作用域注释：
 * Android 类	生成的组件	作用域
 * Application	ApplicationComponent	@Singleton
 * View Model	ActivityRetainedComponent	@ActivityRetainedScope
 * Activity	ActivityComponent	@ActivityScoped
 * Fragment	FragmentComponent	@FragmentScoped
 * View	ViewComponent	@ViewScoped
 * 带有 @WithFragmentBindings 注释的 View	ViewWithFragmentComponent	@ViewScoped
 * Service	ServiceComponent	@ServiceScoped
 */
@ActivityScoped//作用域限定为Activity
class AnalyticsAdapter @Inject constructor(
    @ActivityContext private val context: Context,
    private val service: AnalyticsService
) {

}