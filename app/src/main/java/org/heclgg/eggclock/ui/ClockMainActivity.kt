package org.heclgg.eggclock.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.ViewModelProvider
import org.heclgg.eggclock.R
import org.heclgg.eggclock.viewModel.ClockMainViewModel

/**
 * 桌面时钟主页面
 *
 * @author heclgg
 * @since 2024/12/13
 */
class ClockMainActivity : AppCompatActivity() {

    private lateinit var viewModel: ClockMainViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemBar()
        setContentView(R.layout.clock_main)
        viewModel = ViewModelProvider(this)[ClockMainViewModel::class.java]
        viewModel.getTime()
        viewModel.fullTime.observe(this) { time ->
            findViewById<TextView>(R.id.main_time).text = time
        }
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