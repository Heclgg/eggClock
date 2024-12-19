package org.heclgg.eggclock

import android.app.Activity
import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

/**
 * 桌面时钟主页面
 *
 * @author heclgg
 * @since 2024/12/13
 */
class ClockMainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemBar()
        setContentView(R.layout.clock_main)
    }

    /**
     * 隐藏系统状态栏和导航栏
     */
    private fun hideSystemBar() =
        WindowCompat.getInsetsController(window, window.decorView).apply {
            systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            hide(WindowInsetsCompat.Type.systemBars())
        }
}