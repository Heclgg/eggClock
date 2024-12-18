package org.heclgg.eggclock.utils

import android.content.Context

/**
 * 桌面显示工具类
 *
 * @author heclgg
 * @since 2024/12/18
 */
object WindowUtil {
    private const val TAG = "WindowUtil"

    /**
     * 是否为横屏
     *
     * @param context
     * @return true 横屏
     */
    @JvmStatic
    fun getRotation(context: Context) =
        context.display?.rotation == 1
}