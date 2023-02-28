package com.example.a4month_dz2.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.a4month_dz2.models.NoteModel

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(noteModel: NoteModel)

    @Query("SELECT * FROM note")
    fun getAll(): LiveData<List<NoteModel>>

    @Delete
    fun delete(noteModel: NoteModel)
}