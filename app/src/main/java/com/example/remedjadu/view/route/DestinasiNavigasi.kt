package com.example.remedjadu.view.route

interface DestinasiNavigasi {
    /**
     * Nama unik untuk menentukan jalur untuk composale
     */
    val route: String

    /**
     * String resource id yang berisi judul yang akan di tampilkan di layar
     */
    val titleRes: Int
}