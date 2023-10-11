package com.andreisingeleytsev.casinoclubapp.ui.screens.game_screen

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.compose.ui.util.lerp
import androidx.hilt.navigation.compose.hiltViewModel
import com.andreisingeleytsev.casinoclubapp.R
import com.andreisingeleytsev.casinoclubapp.ui.theme.Golden
import com.andreisingeleytsev.casinoclubapp.ui.utils.Fonts
import com.andreisingeleytsev.casinoclubapp.ui.utils.UIEvents
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GameScreen(viewModel: GSViewModel = hiltViewModel()) {

    val pager1 = rememberPagerState()
    val pager2 = rememberPagerState()
    val pager3 = rememberPagerState()
    val coroutine1 = rememberCoroutineScope()
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect {
            when (it) {
                is UIEvents.Roll -> {
                    Log.d("tag", it.index.toString())
                    coroutine1.launch {
                        pager1.animateScrollToPage(it.index)
                        pager2.animateScrollToPage(it.index)
                        pager3.animateScrollToPage(it.index)
                    }
                }
            }
        }
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BoxWithConstraints(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
                val height = 1.124*maxWidth
                Image(
                    painter = painterResource(id = R.drawable.field),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(start = 0.175 * maxWidth, end = 0.175 * maxWidth)
                        .fillMaxWidth()
                ) {
                    VerticalPager(
                        contentPadding = PaddingValues(top = 0.13 * height, bottom = 0.13 * height),
                        state = pager1,
                        pageCount = viewModel.listFirth.size,
                        modifier = Modifier
                            .padding(top = 0.52 * height)
                            .height(0.322 * height),
                        beyondBoundsPageCount = 5
                    ) { page ->
                        Image(
                            painter = painterResource(id = viewModel.listFirth[page]),
                            contentDescription = null,
                            modifier = Modifier
                                .size(0.064 * height)
                                .graphicsLayer {
                                    // Calculate the absolute offset for the current page from the
                                    // scroll position. We use the absolute value which allows us to mirror
                                    // any effects for both directions
                                    val pageOffset = (
                                            (pager1.currentPage - page) + pager1
                                                .currentPageOffsetFraction
                                            ).absoluteValue

                                    // We animate the alpha, between 50% and 100%
                                    alpha = lerp(
                                        start = 0.2f,
                                        stop = 1f,
                                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                    )
                                    scaleY = lerp(
                                        start = 0.6f,
                                        stop = 1f,
                                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                    )
                                })
                    }
                    VerticalPager(
                        contentPadding = PaddingValues(top = 0.13*height, bottom = 0.13*height),
                        state = pager2,
                        pageCount = viewModel.listSecond.size,
                        modifier = Modifier
                            .padding(top = 0.52 * height)
                            .height(0.322 * height),
                        beyondBoundsPageCount = 5
                    ) { page ->
                        Image(
                            painter = painterResource(id = viewModel.listSecond[page]),
                            contentDescription = null,
                            modifier = Modifier
                                .size(0.064 * height)
                                .graphicsLayer {
                                    // Calculate the absolute offset for the current page from the
                                    // scroll position. We use the absolute value which allows us to mirror
                                    // any effects for both directions
                                    val pageOffset = (
                                            (pager2.currentPage - page) + pager2
                                                .currentPageOffsetFraction
                                            ).absoluteValue

                                    // We animate the alpha, between 50% and 100%
                                    alpha = lerp(
                                        start = 0.2f,
                                        stop = 1f,
                                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                    )
                                    scaleY = lerp(
                                        start = 0.6f,
                                        stop = 1f,
                                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                    )
                                })
                    }
                    VerticalPager(
                        contentPadding = PaddingValues(top = 0.13*height, bottom = 0.13*height),
                        state = pager3,
                        pageCount = viewModel.listThird.size,
                        modifier = Modifier
                            .padding(top = 0.52 * height)
                            .height(0.322 * height),
                        beyondBoundsPageCount = 5
                    ) { page ->
                        Image(
                            painter = painterResource(id = viewModel.listThird[page]),
                            contentDescription = null,
                            modifier = Modifier
                                .size(0.064 * height)
                                .graphicsLayer {
                                    // Calculate the absolute offset for the current page from the
                                    // scroll position. We use the absolute value which allows us to mirror
                                    // any effects for both directions
                                    val pageOffset = (
                                            (pager3.currentPage - page) + pager3
                                                .currentPageOffsetFraction
                                            ).absoluteValue

                                    // We animate the alpha, between 50% and 100%
                                    alpha = lerp(
                                        start = 0.2f,
                                        stop = 1f,
                                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                    )
                                    scaleY = lerp(
                                        start = 0.6f,
                                        stop = 1f,
                                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                    )
                                })
                    }
                }
                Card(
                    shape = RoundedCornerShape(5.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White.copy(alpha = 0.1F)
                    ),
                    modifier = Modifier
                        .padding(
                            start = 0.1 * maxWidth,
                            end = 0.1 * maxWidth,
                            top = 0.64 * height
                        )
                        .height(0.08 * height)
                        .fillMaxWidth()
                ) {

                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 15.dp)
            ) {
                BoxWithConstraints(modifier = Modifier.width(200.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.result_field),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        text = stringResource(id = viewModel.mainText.value).uppercase(), style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = Fonts.font,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier
                            .padding(top = 40.dp, start = 30.dp, end = 30.dp)
                            .fillMaxWidth()
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.handle),
                    contentDescription = null,
                    modifier = Modifier
                        .width(30.dp)
                        .clickable {
                            viewModel.onEvent(GameScreenEvent.OnHandlerPressed)
                        },
                    contentScale = ContentScale.FillWidth
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .padding(13.dp)
                    .fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.coin),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = viewModel.money.value.toString(), style = TextStyle(
                            color = Golden, fontFamily = Fonts.font, fontSize = 20.sp
                        )
                    )
                }
                BoxWithConstraints(modifier = Modifier.width(100.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.bet),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                    Column(
                        Modifier.padding(start = 10.dp, end = 10.dp, top = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Icon(
                                painterResource(id = R.drawable.plus),
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier
                                    .size(10.dp)
                                    .clickable {
                                        viewModel.onEvent(GameScreenEvent.OnPlusBet)
                                    }
                            )
                            Icon(
                                painterResource(id = R.drawable.minus),
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier
                                    .size(10.dp)
                                    .clickable {
                                        viewModel.onEvent(GameScreenEvent.OnMinusBet)
                                    }
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = viewModel.betSize.value.toString() + "$", style = TextStyle(
                                color = Golden, fontFamily = Fonts.font, fontSize = 14.sp
                            )
                        )
                    }
                }
            }
        }
    }
}