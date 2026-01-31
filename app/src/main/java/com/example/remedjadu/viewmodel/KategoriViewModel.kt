package com.example.remedjadu.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.remedjadu.repositori.RepositoriBuku
import com.example.remedjadu.room.Kategori

class KategoriViewModel(
    private val repositori: RepositoriBuku
) : ViewModel() {

    var uiStateKategori by mutableStateOf(KategoriUiState())
        private set

    private fun validasiInput(
        detail: DetailKategori = uiStateKategori.detailKategori
    ): Boolean {
        return detail.nama.isNotBlank()
    }

    fun updateUiState(detailKategori: DetailKategori) {
        uiStateKategori = KategoriUiState(
            detailKategori = detailKategori,
            isEntryValid = validasiInput(detailKategori)
        )
    }

    suspend fun saveKategori() {
        if (validasiInput()) {
            repositori.insertKategori(uiStateKategori.detailKategori.toKategori())
        }
    }
}

/* ---------- UI STATE ---------- */

data class KategoriUiState(
    val detailKategori: DetailKategori = DetailKategori(),
    val isEntryValid: Boolean = false
)

data class DetailKategori(
    val id: Int = 0,
    val nama: String = ""
)

fun DetailKategori.toKategori(): Kategori =
    Kategori(
        id = id,
        nama = nama
    )
