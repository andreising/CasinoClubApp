package com.andreisingeleytsev.casinoclubapp.ui.screens.game_screen

import android.app.Application
import android.content.Context
import android.os.CountDownTimer
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.casinoclubapp.R
import com.andreisingeleytsev.casinoclubapp.ui.utils.UIEvents
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class GSViewModel(app: Application): AndroidViewModel(application = app) {
    private val _uiEvent = Channel<UIEvents>()
    val uiEvent = _uiEvent.receiveAsFlow()
    fun onEvent(event: GameScreenEvent) {
        when (event) {
            is GameScreenEvent.OnHandlerPressed -> {
                if (!isRoll.value) {
                    isRoll.value = true
                    if (money.value>=betSize.value) {
                        index+=3
                        sendUIEvent(
                            UIEvents.Roll(
                                index
                            ))
                        if (listFirth[index]==listSecond[index]&&listSecond[index]==listThird[index]) {
                            if (listFirth[index]== R.drawable.icon_14) {
                                result(100*betSize.value, R.string.jackpot)
                            } else {
                                result(3*betSize.value, R.string.you_win)
                            }
                        } else {
                            result(-1*betSize.value, R.string.you_lose)
                            if (money.value==0) object : CountDownTimer(500, 500) {
                                override fun onTick(p0: Long) {

                                }

                                override fun onFinish() {
                                    result(1000, R.string.plus1000)
                                }

                            }.start()
                        }
                    } else mainText.value = R.string.not_enough_money
                    object : CountDownTimer(2000, 2500){
                        override fun onTick(p0: Long) {

                        }

                        override fun onFinish() {
                            mainText.value = R.string.tap_on_handler
                            isRoll.value = false
                        }

                    }.start()
                }
            }
            is GameScreenEvent.OnPlusBet -> {
                betSize.value+=50
            }
            is GameScreenEvent.OnMinusBet -> {
                val currentBet = betSize.value-50
                if (currentBet>0) betSize.value = currentBet
            }
        }
    }

    private fun sendUIEvent(event: UIEvents){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

    private fun result(bet: Int, textResource: Int) {
        val currentBalance = money.value+bet
        sharedPreferences.edit().putInt("user_balance", currentBalance).apply()
        money.value = currentBalance
        mainText.value = textResource
    }
    private val sharedPreferences = app.getSharedPreferences("shared_pref", Context.MODE_PRIVATE)

    private val list = listOf(
        R.drawable.icon_1,
        R.drawable.icon_2,
        R.drawable.icon_3,
        R.drawable.icon_4,
        R.drawable.icon_5,
        R.drawable.icon_6,
        R.drawable.icon_7,
        R.drawable.icon_8,
        R.drawable.icon_9,
        R.drawable.icon_10,
        R.drawable.icon_11,
        R.drawable.icon_12,
        R.drawable.icon_13,
        R.drawable.icon_14
    )
    private var index = 2
    val listFirth = mutableListOf<Int>().also {
        for (i in 0..10000) {
            it.add(list[(0..13).random()])
        }
    }
    val listSecond = mutableListOf<Int>().also {
        for (i in 0..10000) {
            it.add(list[(0..13).random()])
        }
    }
    val listThird = mutableListOf<Int>().also {
        for (i in 0..10000) {
            it.add(list[(0..13).random()])
        }
    }
    val money = mutableStateOf(sharedPreferences.getInt("user_balance", 850))
    val betSize = mutableStateOf(
        500
    )
    val mainText = mutableStateOf(
        R.string.tap_on_handler
    )
    private val isRoll = mutableStateOf(
        false
    )
}