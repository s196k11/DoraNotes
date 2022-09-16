package com.example.doranotes.Screens.DisplayNote

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.doranotes.MainViewModel.MainViewModel
import com.example.doranotes.Model.Note
import com.example.doranotes.Navigation.NavRoutes

@Composable
fun DisplayNote(mainViewModel: MainViewModel) {
    val conf = LocalConfiguration.current
    val height = conf.screenHeightDp.dp


//    val note : Note= mainViewModel.searchByTitle(title = "this 1")
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(height / 12)) {
            Text(text = "Edit", color = Color.Blue.copy(alpha = 0.8f), modifier = Modifier
                .align(
                    Alignment.CenterEnd)
                .padding(4.dp))
        }

        Spacer(modifier = Modifier.height(20.dp))


    }

}