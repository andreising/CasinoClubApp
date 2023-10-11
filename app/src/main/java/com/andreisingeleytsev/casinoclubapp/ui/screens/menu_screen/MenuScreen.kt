package com.andreisingeleytsev.casinoclubapp.ui.screens.menu_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.casinoclubapp.R
import com.andreisingeleytsev.casinoclubapp.ui.utils.Fonts
import com.andreisingeleytsev.casinoclubapp.ui.utils.Routes

@Composable
fun MenuScreen(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        BoxWithConstraints(
            modifier = Modifier.padding(40.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            val width = maxWidth / 5
            Image(
                painter = painterResource(id = R.drawable.vegas),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Column(Modifier.padding(width)) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navHostController.navigate(Routes.GAME_SCREEN)
                    }, contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.red_button),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        text = stringResource(R.string.new_game), style = TextStyle(
                        color = Color.White, fontFamily = Fonts.font, fontSize = 18.sp
                    ))
                }
                Spacer(modifier = Modifier.height(18.dp))
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navHostController.navigate(Routes.RULES_SCREEN)
                    }, contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.red_button),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                    Text(text = stringResource(R.string.rules), style = TextStyle(
                        color = Color.White, fontFamily = Fonts.font, fontSize = 18.sp
                    ))
                }
            }
        }
    }
}