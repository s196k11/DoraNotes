package com.example.doranotes.Repository

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

    suspend fun searchByTitle(title:String){
        noteDao.searchByTitle(title)
    }

    suspend fun update(note:Note){
        noteDao.update(note)
    }
}