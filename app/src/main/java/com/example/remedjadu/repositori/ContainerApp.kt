package com.example.remedjadu.repositori

import android.app.Application
import android.content.Context
import com.example.remedjadu.room.DatabaseBuku

interface ContainerApp {
    val repositoriBuku: RepositoriBuku
}

class ContainerDataApp(private val context: Context) : ContainerApp {

    override val repositoriBuku: RepositoriBuku by lazy {
        OfflineRepositoriBuku(
            DatabaseBuku.getDatabase(context).bukuDao(),
            DatabaseBuku.getDatabase(context).kategoriDao()
        )
    }
}

class AplikasiPeminjamanBuku : Application() {

    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}
