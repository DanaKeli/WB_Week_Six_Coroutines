package com.example.wb_week_six_coroutines

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class VM : ViewModel() {

    companion object {
        const val TIMER_INTERVAL = 1000L
        const val CALCULATOR_INTERVAL = 10L
    }

    val pi: MutableLiveData<String> = MutableLiveData("")
    val time: MutableLiveData<Long> = MutableLiveData(0L)
    private lateinit var scope: Job

    fun onStart() {
        scope = viewModelScope.launch {
            launch { while (true) startCalculator() }
            launch { while (true) startTimer() }
        }
    }

    fun onPause() {
        stop()
    }

    fun onReset() {
        stop()
        time.value = 0L
        pi.value = ""
    }

    private fun stop() {
        scope.cancel()
    }

    private suspend fun startTimer() {
        time.postValue(time.value?.plus(1000))
        delay(TIMER_INTERVAL)
    }

    private suspend fun startCalculator() {
        pi.postValue(pi.value?.plus((0..9).random()).toString())
        delay(CALCULATOR_INTERVAL)
    }
}
