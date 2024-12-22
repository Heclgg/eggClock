package org.heclgg.eggclock.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextClock
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import org.heclgg.eggclock.R
import org.heclgg.eggclock.viewModel.ClockMainViewModel
import java.util.TimeZone

/**
 * 桌面时钟主页面
 *
 * @author heclgg
 * @since 2024/12/13
 */
class ClockMainActivity : AppCompatActivity() {

    private lateinit var viewModel: ClockMainViewModel

    private lateinit var tcTimeText12: TextClock
    private lateinit var tcDateText12: TextClock
    private lateinit var tcTimeText24: TextClock
    private lateinit var tcDateText24: TextClock

    private lateinit var tv12Hour: TextView
    private lateinit var tv24Hour: TextView
    private lateinit var tvIs24HourModeEnabled: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.clock_main)
        viewModel = ViewModelProvider(this)[ClockMainViewModel::class.java]
//        viewModel.handler.post(viewModel.updateTimeRunnable)
//        viewModel.fullTime.observe(this) { time ->
//            findViewById<TextView>(R.id.main_time).text = time
//        }
        initView()
    }

    private fun initView() {
        tvIs24HourModeEnabled = findViewById(R.id.tv_is24HourModeEnabled)

        tcTimeText12 = findViewById(R.id.tc_timeText_12)
        tcDateText12 = findViewById(R.id.tc_dateText_12)
        tv12Hour = findViewById(R.id.tv_12hour)

        // Set time zone using (UTC-7)
        tcTimeText12.setTimeZone("America/Los_Angeles") // Effective
        tcDateText12.setTimeZone("America/Los_Angeles") // Effective
        // tcTimeText12.setTimeZone("GMT+7:00") // Effective
        // tcDateText12.setTimeZone("GMT+7:00") // Effective

        tcDateText12.setFormat24Hour("HH:mm")
        tcDateText12.setFormat12Hour("yyyy/MM/dd E")
        // EEEE: 星期五；E/EE/EEE: 周五；a: 上午/下午
        tcDateText12.setFormat24Hour("yyyy年MM月dd日 EEEE aa HH:mm:ss")

        val format12 = StringBuilder()
            .append("\n12小时模式格式: ${tcTimeText12.getFormat12Hour()}")
            .append("\n24小时模式格式: ${tcTimeText12.getFormat24Hour()}")
            .append("\n时区: ${tcTimeText12.getTimeZone()}")
            .toString()

        tv12Hour.text = "Format：$format12"

        tcTimeText24 = findViewById(R.id.tc_timeText_24)
        tcDateText24 = findViewById(R.id.tc_dateText_24)
        tv24Hour = findViewById(R.id.tv_24hour)

        val format = StringBuilder()
            .append("\n24小时模式格式: ${tcTimeText24.getFormat24Hour()}")
            .append("\n12小时模式格式: ${tcTimeText24.getFormat12Hour()}")
            .append("\n时区: ${tcTimeText24.getTimeZone()}")
            .append("\n时区: ${TimeZone.getDefault().displayName}")
            .toString()

        tv24Hour.text = "Format：$format"

        val is24HourMode = "系统当前是否使用 24 小时模式：${tcDateText24.is24HourModeEnabled()}。"
        tvIs24HourModeEnabled.text = is24HourMode
    }
}