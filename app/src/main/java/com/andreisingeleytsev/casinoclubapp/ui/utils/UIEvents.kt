package com.andreisingeleytsev.casinoclubapp.ui.utils

sealed class UIEvents(){
    data class Roll(val index: Int): UIEvents()
}
