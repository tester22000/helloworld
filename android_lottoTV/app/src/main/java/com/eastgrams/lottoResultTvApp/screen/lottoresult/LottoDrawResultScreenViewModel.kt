package com.eastgrams.lottoResultTvApp.screen.lottoresult

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eastgrams.lottoResultTvApp.data.LottoDrawServiceResult
import com.eastgrams.lottoResultTvApp.data.repository.LottoDrawResultServiceRepository
import com.eastgrams.lottoResultTvApp.utils.lastDrawnNo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class LottoDrawResultScreenUIState(
    var drwNo: Int? = null,
    var lottoDrawServiceResult: LottoDrawServiceResult? = null
)

sealed class LottoDrawResultScreenEvent {
    data class DrwNoChanged(val drwNo: Int) : LottoDrawResultScreenEvent()
}

@HiltViewModel
class LottoDrawResultScreenViewModel @Inject constructor(
    private val lottoDrawResultServiceRepository: LottoDrawResultServiceRepository
) : ViewModel() {
    private val vmState = MutableStateFlow(
        LottoDrawResultScreenUIState(
            drwNo = lastDrawnNo()
        )
    )

    val uiState = vmState.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        vmState.value
    )


    private fun getLottoResult(drwNo: Int) {
        viewModelScope.launch {
            var lottoDrawResult = if (drwNo <= lastDrawnNo()) {
                lottoDrawResultServiceRepository.getLottoDrawResult(drwNo)
            } else {
                null
            }
            if (lottoDrawResult != null) {
                vmState.update {
                    it.copy(
                        drwNo = drwNo,
                        lottoDrawServiceResult = lottoDrawResult,
                    )
                }
            }
        }
    }

    fun initModel() {
        viewModelScope.launch {
            getLottoResult(drwNo = vmState.value.drwNo!!)
        }
    }


    fun onEvent(event: LottoDrawResultScreenEvent) {
        when (event) {
            is LottoDrawResultScreenEvent.DrwNoChanged -> {
                viewModelScope.launch {
                    getLottoResult(drwNo = event.drwNo)
                }
            }
        }
    }
}