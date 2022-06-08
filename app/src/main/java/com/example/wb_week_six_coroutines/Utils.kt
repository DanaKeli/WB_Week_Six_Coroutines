package com.example.wb_week_six_coroutines

import android.graphics.Color
import android.util.Log
import java.util.*
import java.util.concurrent.TimeUnit

object Utils {
    fun getFormattedTime(ms: Long): String {
        var milliseconds = ms
        val hours = TimeUnit.MILLISECONDS.toHours(milliseconds)
        milliseconds -= TimeUnit.HOURS.toMillis(hours)
        val minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds)
        milliseconds -= TimeUnit.MINUTES.toMillis(minutes)
        val seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds)
        Log.i("dana", "sec >>> $seconds")
        return "${if (hours < 10) "0" else ""}$hours:" +
                "${if (minutes < 10) "0" else ""}$minutes:" +
                "${if (seconds < 10) "0" else ""}$seconds"
    }

    fun getColor(): Int {
        val rnd = Random()
        return Color.argb(80, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }


}