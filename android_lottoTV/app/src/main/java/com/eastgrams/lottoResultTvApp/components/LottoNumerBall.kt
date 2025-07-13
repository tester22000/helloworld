package com.eastgrams.lottoResultTvApp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Text
import com.eastgrams.lottoResultTvApp.R

private fun getLottoBall(number: Int): Int {
    return when (number) {
        in 1..10 -> R.drawable.lotto_ball_1
        in 11..20 -> R.drawable.lotto_ball_2
        in 21..30 -> R.drawable.lotto_ball_3
        in 31..40 -> R.drawable.lotto_ball_4
        else -> R.drawable.lotto_ball_5
    }
}

@Composable
fun LottoNumberBall(
    number: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(horizontal = 4.dp)
    ) {
        Image(
            painterResource(id = getLottoBall(number)), contentDescription = "",
            modifier = Modifier
                .width(60.dp)
                .height(60.dp)
                .padding(all = 2.dp)
        )
        Text(
            text = number.toString(),
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}


@Preview
@Composable
fun LottoNumSet2() {
    Row(
        modifier = Modifier
            .width(200.dp)
            .height(50.dp)
            .background(color = Color.White)
    ) {
        LottoNumberBall(number = 1, modifier = Modifier.weight(1f))
        LottoNumberBall(number = 5, modifier = Modifier.weight(1f))
        LottoNumberBall(number = 8, modifier = Modifier.weight(1f))
        LottoNumberBall(number = 10, modifier = Modifier.weight(1f))
        LottoNumberBall(number = 23, modifier = Modifier.weight(1f))
        LottoNumberBall(number = 43, modifier = Modifier.weight(1f))
        LottoNumberBall(number = 27, modifier = Modifier.weight(1f))
    }
}

