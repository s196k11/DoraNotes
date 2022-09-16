package com.example.doranotes.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.doranotes.Model.Note
import kotlinx.coroutines.flow.Flow


@Database(entities = arrayOf(Note::class), version = 1, exportSchema = false)
abstract class NoteDatabase():RoomDatabase() {

    abstract fun noteDao() : NoteDao

    companion object{
        @Volatile
        var INSTANCE : NoteDatabase? = null

        fun getDatabase(
            context: Context
        ):NoteDatabase{
            return INSTANCE ?: synchronized(this){
                var instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "note_database"
                )
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}