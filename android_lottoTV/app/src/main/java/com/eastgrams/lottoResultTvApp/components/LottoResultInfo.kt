package com.eastgrams.lottoResultTvApp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Text

@Composable
fun LottoResultInfo(
    drwNo: Int,
    year: String,
    month: String,
    date: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    )
    {
        Row {
            Text(
                "${drwNo}회",
                style = TextStyle(
                    fontSize = 25.sp,
                    color = Color(212, 51, 1),
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(Modifier.width(10.dp))
            Text(
                "당첨결과",
                style = TextStyle(
                    fontSize = 25.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        Text(
            "(${year}년 ${month}월 ${date}일 추첨)",
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.White
            )

        )
    }
}