package com.andreisingeleytsev.casinoclubapp.ui.screens.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.andreisingeleytsev.casinoclubapp.R
import com.andreisingeleytsev.casinoclubapp.ui.utils.Routes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navHostController: NavHostController) {
    val coroutineContext = rememberCoroutineScope()
    coroutineContext.launch {
        delay(2000)
        navHostController.navigate(Routes.MENU_SCREEN){
            popUpTo(Routes.SPLASH_SCREEN){
                inclusive = true
            }
        }
    }
    Image(
        painter = painterResource(id = R.drawable.splash),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}