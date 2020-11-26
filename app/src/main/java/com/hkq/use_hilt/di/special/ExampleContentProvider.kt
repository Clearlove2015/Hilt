package com.hkq.use_hilt.di.special

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import com.hkq.use_hilt.di.AnalyticsService
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.components.ApplicationComponent

/**
 * 在 Hilt 不支持的类中注入依赖项
 * Hilt 目前支持以下 Android 类：
 * Application（通过使用 @HiltAndroidApp）
 * Activity
 * Fragment
 * View
 * Service
 * BroadcastReceiver
 * 如果您使用 @AndroidEntryPoint 为某个 Android 类添加注释，则还必须为依赖于该类的 Android 类添加注释。例如，如果您为某个 Fragment 添加注释，则还必须为使用该 Fragment 的所有 Activity 添加注释。
 * 注意：在 Hilt 对 Android 类的支持方面还要注意以下几点：
 * Hilt 仅支持扩展 ComponentActivity 的 Activity，如 AppCompatActivity。
 * Hilt 仅支持扩展 androidx.Fragment 的 Fragment。
 * Hilt 不支持保留的 Fragment。
 */
class ExampleContentProvider : ContentProvider() {

    @EntryPoint
    @InstallIn(ApplicationComponent::class)
    interface ExampleContentProviderEntryPoint {
        fun analyticsService(): AnalyticsService
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        val appContext = context?.applicationContext ?: throw IllegalStateException()
        val hiltEntryPoint =
            EntryPointAccessors.fromApplication(
                appContext,
                ExampleContentProviderEntryPoint::class.java
            )
        val analyticsService = hiltEntryPoint.analyticsService()
        TODO("Not yet implemented")
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        TODO("Not yet implemented")
    }

    override fun onCreate(): Boolean {
        TODO("Not yet implemented")
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        TODO("Not yet implemented")
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun getType(uri: Uri): String? {
        TODO("Not yet implemented")
    }
}