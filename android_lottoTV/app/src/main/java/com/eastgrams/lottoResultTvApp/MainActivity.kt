package com.eastgrams.lottoResultTvApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Icon
import androidx.tv.material3.IconButton
import androidx.tv.material3.Surface
import androidx.tv.material3.Text
import com.eastgrams.lottoResultTvApp.components.LottoNumberBall
import com.eastgrams.lottoResultTvApp.components.LottoResultInfo
import com.eastgrams.lottoResultTvApp.components.LottoResultTableColumn
import com.eastgrams.lottoResultTvApp.ui.theme.LottoTvTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LottoTvTheme {
                Surface(
                    modifier = Modifier
                        .background(Color.Black)
                        .fillMaxSize(),
                    shape = RectangleShape,
                ) {
                    LottoTvApp()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(color = Color.Black)
    ) {
        LottoResultInfo(
            drwNo = 1111,
            year = "2025",
            month = "06",
            date = "24",
            modifier = Modifier.padding(top = 65.dp)
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .padding(top = 28.dp)
                .fillMaxWidth()
        ) {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .padding(top = 15.dp, start = 20.dp, end = 20.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.chevron_left_24px),
                    contentDescription = "이전",
                    modifier = Modifier.size(40.dp)
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row {
                    LottoNumberBall(number = 1)
                    LottoNumberBall(number = 11)
                    LottoNumberBall(number = 21)
                    LottoNumberBall(number = 31)
                    LottoNumberBall(number = 41)
                    LottoNumberBall(number = 45)
                }
                Text(
                    "당첨 번호",
                    style = TextStyle(fontSize = 14.sp, color = Color.White),
                    modifier = Modifier
                        .padding(top = 40.dp)
                )
            }
            Text(
                "+",
                style = TextStyle(fontSize = 16.sp, color = Color.White),
                modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 20.dp)
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row {
                    LottoNumberBall(number = 27)
                }
                Text(
                    "보너스",
                    style = TextStyle(fontSize = 14.sp, color = Color.White),
                    modifier = Modifier
                        .padding(top = 40.dp)
                )
            }
            IconButton(
                onClick = {},
                modifier = Modifier
                    .padding(top = 15.dp, start = 20.dp, end = 20.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.chevron_right_24px),
                    contentDescription = "다음",
                    modifier = Modifier.width(80.dp).height(80.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(top = 60.dp)
        ) {
            LottoResultTableColumn(
                width = 200.dp,
                titleText = "1등 총 당첨금액",
                contentText = "28,699,300,884원",
                contentColor = Color.Red,
                Alignment.End
            )
            Spacer(modifier = Modifier.width(1.dp))
            LottoResultTableColumn(
                width = 100.dp,
                titleText = "당첨게임 수",
                contentText = "12"
            )
            Spacer(modifier = Modifier.width(1.dp))
            LottoResultTableColumn(
                width = 200.dp,
                titleText = "1게임당 당첨금액",
                contentText = "2,391,608,407원",
                horizontalAlignment = Alignment.End
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LottoTvTheme {
        Greeting()
    }
}