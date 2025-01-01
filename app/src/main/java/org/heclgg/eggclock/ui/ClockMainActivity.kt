package org.heclgg.eggclock.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.heclgg.eggclock.R

/**
 * 桌面时钟主页面
 *
 * @author heclgg
 * @since 2024/12/13
 */
class ClockMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.clock_main)
    }
}