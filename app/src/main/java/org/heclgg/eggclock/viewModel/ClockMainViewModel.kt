package org.heclgg.eggclock.viewModel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Runnable
import org.heclgg.eggclock.consts.DataFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * 时钟主页面VM
 *
 * @author heclgg
 * @since 2024/12/21
 */

class ClockMainViewModel : ViewModel() {
    /** 年月日时分秒 */
    val fullTime = MutableLiveData<String>()

    /** 年 */
    val year = MutableLiveData<String>()

    /** 月 */
    val month = MutableLiveData<String>()

    /** 日 */
    val day = MutableLiveData<String>()

    /** 时 */
    val hour = MutableLiveData<String>()

    /** 分 */
    val minute = MutableLiveData<String>()

    /** 秒 */
    val second = MutableLiveData<String>()

    val handler = Handler(Looper.getMainLooper())

    val updateTimeRunnable = object : Runnable {
        override fun run() {
            fullTime.postValue(getTime(DataFormat.FULL_TIME))
            year.postValue(getTime(DataFormat.YEAR))
            month.postValue(getTime(DataFormat.MONTH))
            day.postValue(getTime(DataFormat.DAY))
            hour.postValue(getTime(DataFormat.HOUR))
            minute.postValue(getTime(DataFormat.MIN))
            second.postValue(getTime(DataFormat.SEC))
            handler.postDelayed(this, 1000)
        }
    }

    /**
     * 获取当前时间
     *
     * @param format 时间格式
     */
    fun getTime(format: String): String =
        LocalDateTime.now().format(DateTimeFormatter.ofPattern(format))
}