package com.andreisingeleytsev.casinoclubapp.ui.screens.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andreisingeleytsev.casinoclubapp.ui.screens.game_screen.GameScreen
import com.andreisingeleytsev.casinoclubapp.ui.screens.menu_screen.MenuScreen
import com.andreisingeleytsev.casinoclubapp.ui.screens.rules_screen.RulesScreen
import com.andreisingeleytsev.casinoclubapp.ui.screens.splash.SplashScreen
import com.andreisingeleytsev.casinoclubapp.ui.utils.Routes

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun CasinoClubNavigation() {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = Routes.SPLASH_SCREEN) {
        composable(Routes.GAME_SCREEN) {
            GameScreen()
        }
        composable(Routes.MENU_SCREEN) {
            MenuScreen(navHostController)
        }
        composable(Routes.RULES_SCREEN) {
            RulesScreen()
        }
        composable(Routes.SPLASH_SCREEN) {
            SplashScreen(navHostController)
        }
    }
}