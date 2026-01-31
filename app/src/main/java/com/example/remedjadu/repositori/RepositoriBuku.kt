package com.example.remedjadu.repositori

import com.example.remedjadu.room.Buku
import com.example.remedjadu.room.BukuDao
import com.example.remedjadu.room.Kategori
import com.example.remedjadu.room.KategoriDao
import kotlinx.coroutines.flow.Flow

interface RepositoriBuku {

    // ===== Buku =====
    fun getAllBukuStream(): Flow<List<Buku>>
    suspend fun insertBuku(buku: Buku)
    fun getBukuStream(id: Int): Flow<Buku?>
    suspend fun deleteBuku(buku: Buku)
    suspend fun updateBuku(buku: Buku)

    // ===== Kategori =====
    fun getAllKategoriStream(): Flow<List<Kategori>>
    suspend fun insertKategori(kategori: Kategori)
    fun getKategoriStream(id: Int): Flow<Kategori?>
    suspend fun deleteKategori(kategori: Kategori)
    suspend fun updateKategori(kategori: Kategori)
}

class OfflineRepositoriBuku(
    private val bukuDao: BukuDao,
    private val kategoriDao: KategoriDao
) : RepositoriBuku {

    // ===== Buku =====
    override fun getAllBukuStream(): Flow<List<Buku>> =
        bukuDao.getAllBuku()

    override suspend fun insertBuku(buku: Buku) =
        bukuDao.insert(buku)

    override fun getBukuStream(id: Int): Flow<Buku?> =
        bukuDao.getBuku(id)

    override suspend fun deleteBuku(buku: Buku) =
        bukuDao.delete(buku)

    override suspend fun updateBuku(buku: Buku) =
        bukuDao.update(buku)

    // ===== Kategori =====
    override fun getAllKategoriStream(): Flow<List<Kategori>> =
        kategoriDao.getAllKategori()

    override suspend fun insertKategori(kategori: Kategori) =
        kategoriDao.insert(kategori)

    override fun getKategoriStream(id: Int): Flow<Kategori?> =
        kategoriDao.getKategori(id)

    override suspend fun deleteKategori(kategori: Kategori) =
        kategoriDao.delete(kategori)

    override suspend fun updateKategori(kategori: Kategori) =
        kategoriDao.update(kategori)
}