package com.example.remedjadu.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface BukuDao {

    @Query("SELECT * FROM buku ORDER BY judul ASC")
    fun getAllBuku(): Flow<List<Buku>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(buku: Buku)

    @Query("SELECT * FROM buku WHERE id = :id")
    fun getBuku(id: Int): Flow<Buku>

    @Update
    suspend fun update(buku: Buku)

    @Delete
    suspend fun delete(buku: Buku)
}
