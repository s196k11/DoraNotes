package com.example.doranotes

import android.app.Application
import com.example.doranotes.Data.NoteDatabase
import com.example.doranotes.Repository.NoteRepository

class BaseApplication:Application() {

    val database by lazy { NoteDatabase.getDatabase(this) }
    val repository by lazy { NoteRepository(database.noteDao()) }
}