package dev.hotwire.turbo.demo.util

import android.app.Activity
import android.webkit.JavascriptInterface
import dev.hotwire.turbo.activities.TurboActivity

class NavHandler constructor(activity: TurboActivity) {
    private val activity = activity

    companion object {
        const val name = "NavHandler"
    }

    @JavascriptInterface
    fun nav(url: String) {
        val act = activity as Activity
        act.runOnUiThread(
            Runnable {
                activity.delegate.resetSessions()
                activity.delegate.navigate(url)
            }
        )
    }
}