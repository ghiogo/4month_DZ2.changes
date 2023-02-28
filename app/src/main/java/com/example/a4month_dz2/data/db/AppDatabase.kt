package com.example.a4month_dz2.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.a4month_dz2.data.db.daos.NoteDao
import com.example.a4month_dz2.models.NoteModel

@Database(entities = [NoteModel::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}