package com.example.remedjadu.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remedjadu.repositori.RepositoriBuku
import com.example.remedjadu.room.Buku
import com.example.remedjadu.room.Kategori
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    private val repositori: RepositoriBuku
) : ViewModel() {

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val uiState: StateFlow<HomeUiState> =
        repositori.getAllBukuStream()
            .map {
                HomeUiState(
                    listBuku = it,
                    listKategori = emptyList()
                )
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = HomeUiState()
            )
}

data class HomeUiState(
    val listBuku: List<Buku> = listOf(),
    val listKategori: List<Kategori> = listOf()
)
