package com.example.doranotes.Data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.doranotes.Model.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDao {

    @Query("select * from note_table order by title ASC")
    fun getAllNote() : Flow<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note:Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("select * from note_table where title Like :title")
    suspend fun searchByTitle(title:String) : Note

    @Update
    suspend fun update(note:Note)

}