package org.heclgg.eggclock.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Runnable
import java.text.SimpleDateFormat
import java.util.Date

/**
 * 时钟主页面VM
 *
 * @author heclgg
 * @since 2024/12/21
 */
@SuppressLint("SimpleDateFormat")
class ClockMainViewModel : ViewModel() {
    /** 时分秒 */
    val fullTime = MutableLiveData<String>()

    fun getTime() =
        Thread(Runnable {
            try {
                while (true) {
                    Thread.sleep(1000)
                    fullTime.postValue(SimpleDateFormat("HH:mm:ss").format(Date(System.currentTimeMillis())))
                    Log.d("vm", "${fullTime.value}")
                }
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }).start()
}