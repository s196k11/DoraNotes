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

    @Query("UPDATE note_table SET title=:title,description=:description WHERE Id=:id")
    suspend fun update(title: String,description:String,id: Int?)

    @Query("SELECT * FROM NOTE_TABLE WHERE Id  =:Id")
    fun searchById(Id: Int?) : Note?

}