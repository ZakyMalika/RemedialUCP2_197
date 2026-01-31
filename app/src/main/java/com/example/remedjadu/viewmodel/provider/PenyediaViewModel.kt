package com.example.remedjadu.viewmodel.provider


import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.remedjadu.repositori.AplikasiPeminjamanBuku
import com.example.remedjadu.viewmodel.BukuViewModel
import com.example.remedjadu.viewmodel.HomeViewModel
import com.example.remedjadu.viewmodel.KategoriViewModel


object PenyediaViewModel {

    val Factory = viewModelFactory {

        initializer {
            HomeViewModel(aplikasi().container.repositoriBuku)
        }

        initializer {
            BukuViewModel(aplikasi().container.repositoriBuku)
        }

        initializer {
            KategoriViewModel(aplikasi().container.repositoriBuku)
        }
    }
}

fun CreationExtras.aplikasi(): AplikasiPeminjamanBuku =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as
            AplikasiPeminjamanBuku)
