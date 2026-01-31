package com.example.remedjadu.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        Buku::class,
        Kategori::class,
        Author::class
    ],
    version = 1,
    exportSchema = false
)
abstract class DatabaseBuku : RoomDatabase() {

    abstract fun bukuDao(): BukuDao
    abstract fun kategoriDao(): KategoriDao

    companion object {
        @Volatile
        private var Instance: DatabaseBuku? = null

        fun getDatabase(context: Context): DatabaseBuku {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseBuku::class.java,
                    "buku_database"
                ).build().also { Instance = it }
            }
        }
    }
}
