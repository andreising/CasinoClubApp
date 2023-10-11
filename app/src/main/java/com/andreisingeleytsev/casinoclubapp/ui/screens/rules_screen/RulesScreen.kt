package com.andreisingeleytsev.casinoclubapp.ui.screens.rules_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreisingeleytsev.casinoclubapp.R
import com.andreisingeleytsev.casinoclubapp.ui.utils.Fonts

@Preview
@Composable
fun RulesScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(modifier = Modifier
            .padding(40.dp)
            .fillMaxWidth()){
            Image(
                painter = painterResource(id = R.drawable.rectangle),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Text(text = "WARNING: We use virtual money in this game, be careful when you gamble.\nIn this application, you can play the classic slot machine, experience the drive and not spend real money at all!", style = TextStyle(
                color = Color.White, fontFamily = Fonts.font, fontSize = 24.sp, textAlign = TextAlign.Center
            ), modifier = Modifier
                .padding(40.dp)
                .fillMaxWidth()
            )
        }
    }

}