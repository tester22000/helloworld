package com.eastgrams.lottoResultTvApp.screen.lottoresult

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eastgrams.lottoResultTvApp.R
import com.eastgrams.lottoResultTvApp.components.LottoNumberBall
import com.eastgrams.lottoResultTvApp.components.LottoResultInfo
import com.eastgrams.lottoResultTvApp.components.LottoResultTableColumn
import com.eastgrams.lottoResultTvApp.utils.lastDrawnNo


@Composable
fun LottoDrawResultScreen(
    viewModel: LottoDrawResultScreenViewModel
) {
    //val context = LocalContext.current
    val lastDrawNo = lastDrawnNo()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    var lottoDrawServiceResult = uiState.lottoDrawServiceResult

    LaunchedEffect(true) {
        viewModel.initModel()
    }

    var yearStr = lottoDrawServiceResult?.drawDate?.substring(0,4)
    var monthStr = lottoDrawServiceResult?.drawDate?.substring(5,7)
    var dateStr = lottoDrawServiceResult?.drawDate?.substring(8,10)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(color = Color.Black).fillMaxHeight()
    ) {
        LottoResultInfo(
            drwNo = uiState.drwNo!!,
            year = yearStr ?: "",
            month = monthStr ?: "",
            date = dateStr ?: "",
            modifier = Modifier.padding(top = 65.dp)
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .padding(top = 60.dp)
                .fillMaxWidth()
        ) {
            if (uiState.drwNo != null && uiState.drwNo!! > 1) {
                IconButton(
                    onClick = {
                        viewModel.onEvent(LottoDrawResultScreenEvent.DrwNoChanged(drwNo = uiState.drwNo!! - 1))
                    },
                    modifier = Modifier
                        .padding(top = 10.dp, start = 20.dp, end = 20.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.chevron_left_24px),
                        contentDescription = "이전",
                        tint = Color.White,
                        modifier = Modifier.size(40.dp)
                    )
                }
            } else {
                IconButton(
                    onClick = {
                    },
                    modifier = Modifier
                        .padding(top = 10.dp, start = 20.dp, end = 20.dp)
                ) {
                }
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row {
                    LottoNumberBall(number = lottoDrawServiceResult?.drawNo1 ?: 0)
                    LottoNumberBall(number = lottoDrawServiceResult?.drawNo2 ?: 0)
                    LottoNumberBall(number = lottoDrawServiceResult?.drawNo3 ?: 0)
                    LottoNumberBall(number = lottoDrawServiceResult?.drawNo4 ?: 0)
                    LottoNumberBall(number = lottoDrawServiceResult?.drawNo5 ?: 0)
                    LottoNumberBall(number = lottoDrawServiceResult?.drawNo6 ?: 0)
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
                    LottoNumberBall(number = lottoDrawServiceResult?.bonusNo ?: 0)
                }
                Text(
                    "보너스",
                    style = TextStyle(fontSize = 14.sp, color = Color.White),
                    modifier = Modifier
                        .padding(top = 40.dp)
                )
            }
            if (uiState.drwNo != null && uiState.drwNo!! < lastDrawNo) {
                IconButton(
                    onClick = {
                        viewModel.onEvent(LottoDrawResultScreenEvent.DrwNoChanged(drwNo = uiState.drwNo!! + 1))
                    },
                    modifier = Modifier
                        .padding(top = 10.dp, start = 20.dp, end = 20.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.chevron_right_24px),
                        contentDescription = "다음",
                        tint = Color.White,
                                modifier = Modifier.size(40.dp)
                    )
                }
            } else {
                IconButton(
                    onClick = {
                    },
                    modifier = Modifier
                        .padding(top = 10.dp, start = 20.dp, end = 20.dp)
                ) {
                }
            }
        }
        Row(
            modifier = Modifier
                .padding(top = 60.dp, start = 100.dp, end=100.dp)
        ) {
            LottoResultTableColumn(
                width = 200.dp,
                titleText = "1등 총 당첨금액",
                contentText = "${lottoDrawServiceResult?.firstAccumamntString() ?: "0"}원",
                contentColor = Color.Red,
                Alignment.End,
                        modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(1.dp))
            LottoResultTableColumn(
                width = 100.dp,
                titleText = "당첨게임 수",
                contentText = "${lottoDrawServiceResult?.firstWinCount ?: "-"}"
            )
            Spacer(modifier = Modifier.width(1.dp))
            LottoResultTableColumn(
                width = 200.dp,
                titleText = "1게임당 당첨금액",
                contentText = "${lottoDrawServiceResult?.firstWinAmountString() ?: "0"}원",
                horizontalAlignment = Alignment.End,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
