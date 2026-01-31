package com.example.remedjadu.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.remedjadu.repositori.RepositoriBuku
import com.example.remedjadu.room.Buku

class BukuViewModel(
    private val repositori: RepositoriBuku
) : ViewModel() {

    var uiStateBuku by mutableStateOf(BukuUiState())
        private set

    private fun validasiInput(
        detail: DetailBuku = uiStateBuku.detailBuku
    ): Boolean {
        return detail.judul.isNotBlank() && detail.kategoriId > 0
    }

    fun updateUiState(detailBuku: DetailBuku) {
        uiStateBuku = BukuUiState(
            detailBuku = detailBuku,
            isEntryValid = validasiInput(detailBuku)
        )
    }

    suspend fun saveBuku() {
        if (validasiInput()) {
            repositori.insertBuku(uiStateBuku.detailBuku.toBuku())
        }
    }
}

/* ---------- UI STATE ---------- */

data class BukuUiState(
    val detailBuku: DetailBuku = DetailBuku(),
    val isEntryValid: Boolean = false
)

data class DetailBuku(
    val id: Int = 0,
    val judul: String = "",
    val kategoriId: Int = 0
)

fun DetailBuku.toBuku(): Buku =
    Buku(
        id = id,
        judul = judul,
        kategoriId = kategoriId
    )
