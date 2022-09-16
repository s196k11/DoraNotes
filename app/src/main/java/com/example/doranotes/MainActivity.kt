package com.example.doranotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.doranotes.MainViewModel.MainViewModel
import com.example.doranotes.MainViewModel.MainViewModelFactory
import com.example.doranotes.Screens.AddNote.AddNote
import com.example.doranotes.Screens.HomeScreen.HomeScreen
import com.example.doranotes.Screens.MainScreen.MainScreen
import com.example.doranotes.ui.theme.DoraNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoraNotesTheme {
                val mainViewModel:MainViewModel by viewModels {
                    MainViewModelFactory((application as BaseApplication).repository)
                }

                MainScreen(viewModel = mainViewModel)

            }
        }
    }
}

