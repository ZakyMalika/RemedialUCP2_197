package com.example.remedjadu.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface KategoriDao {

    @Query("SELECT * FROM kategori ORDER BY nama ASC")
    fun getAllKategori(): Flow<List<Kategori>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(kategori: Kategori)

    @Query("SELECT * FROM kategori WHERE id = :id")
    fun getKategori(id: Int): Flow<Kategori>

    @Update
    suspend fun update(kategori: Kategori)

    @Delete
    suspend fun delete(kategori: Kategori)
}
