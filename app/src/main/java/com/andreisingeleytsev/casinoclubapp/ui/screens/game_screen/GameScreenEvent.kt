package com.andreisingeleytsev.casinoclubapp.ui.screens.game_screen

sealed class GameScreenEvent {
    object OnHandlerPressed: GameScreenEvent()
    object OnPlusBet: GameScreenEvent()
    object OnMinusBet: GameScreenEvent()
}
