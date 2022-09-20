package com.example.doranotes.MainViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.*
import com.example.doranotes.Model.Note
import com.example.doranotes.Repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel(private val repository: NoteRepository) : ViewModel() {

//    var currentNote by mutableStateOf("")

    var currentNote: Note? by mutableStateOf(null)

    fun getAllNote():LiveData<List<Note>> = repository.getAllNotes().asLiveData()

    fun insert(note: Note) = viewModelScope.launch {
        repository.insert(note)
    }

    fun delete(note:Note) = viewModelScope.launch {
        repository.delete(note)
    }

    fun searchByTitle(title:String) = viewModelScope.launch {
        repository.searchByTitle(title)
    }

    fun update(title: String,description :String,id: Int?) = viewModelScope.launch {
        repository.update(title,description, id)
    }


//    fun searchNoteById(id:Int?) = viewModelScope.launch{
//        repository.searchNoteById(id)
//    }

//    suspend fun searchNoteById(id: Int?) = repository.searchNoteById(id)

    fun searchNoteById(id:Int?) = viewModelScope.launch(Dispatchers.IO) {
        currentNote = repository.searchNoteById(id)
    }
}


class MainViewModelFactory(private val repository: NoteRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown viewModel")
    }
}