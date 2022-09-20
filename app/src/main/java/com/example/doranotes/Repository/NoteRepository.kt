package com.example.doranotes.Repository

import android.icu.text.CaseMap
import com.example.doranotes.Data.NoteDao
import com.example.doranotes.Model.Note
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val noteDao: NoteDao) {

    fun getAllNotes():Flow<List<Note>> = noteDao.getAllNote()

    suspend fun insert(note:Note){
        noteDao.insert(note)
    }

    suspend fun delete(note:Note){
        noteDao.delete(note)
    }

    suspend fun update(title: String,description:String,id: Int?){
        noteDao.update(title = title,description = description,id = id)
    }

//    suspend fun searchByTitle(title:String){
//        noteDao.searchByTitle(title)
//    }

    suspend fun searchByTitle(title: String):Note?{
        return noteDao.searchByTitle(title)
    }


    suspend fun searchNoteById(id: Int?): Note?{
        return noteDao.searchById(id)
    }

}