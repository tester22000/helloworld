package com.eastgrams.lottoResultTvApp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Text

@Composable
fun LottoResultTableColumn(
    width: Dp,
    titleText: String,
    contentText: String,
    contentColor: Color = Color.Black,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    modifier : Modifier = Modifier
){
    Column(
        modifier = modifier.width(width)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(245,245,245))
                .height(40.dp)
        ) {
            Text(
                titleText,
                style = TextStyle(fontSize = 14.sp, color = Color.Black)
            )
        }
        Spacer(modifier=Modifier.height(1.dp))
        Column(
            horizontalAlignment = horizontalAlignment,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .height(40.dp)
        ) {
            val padding = if (horizontalAlignment == Alignment.End) 5.0.dp else 0.dp
            Text(contentText,
                style = TextStyle(fontSize = 14.sp, color=contentColor),
                modifier=Modifier.padding(end=padding)
            )
        }
    }
}