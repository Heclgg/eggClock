package org.heclgg.eggclock.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

//    private lateinit var viewModel: ClockMainViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.clock_main)
//        viewModel = ViewModelProvider(this)[ClockMainViewModel::class.java]
    }
}