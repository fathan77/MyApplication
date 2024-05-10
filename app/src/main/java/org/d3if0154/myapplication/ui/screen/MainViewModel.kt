package org.d3if0154.myapplication.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.d3if0154.myapplication.database.PenjualanDao
import org.d3if0154.myapplication.model.Penjualan
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class MainViewModel(dao: PenjualanDao) : ViewModel() {

    val data: StateFlow<List<Penjualan>> = dao.getPenjualan().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )
}