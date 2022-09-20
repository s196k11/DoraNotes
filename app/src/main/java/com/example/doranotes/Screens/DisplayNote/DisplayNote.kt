package com.example.doranotes.Screens.DisplayNote

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.doranotes.MainViewModel.MainViewModel
import com.example.doranotes.Model.Note
import com.example.doranotes.Navigation.NavRoutes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Composable
fun DisplayNote(viewModel: MainViewModel, id: Int?,navController: NavHostController) {
    val conf = LocalConfiguration.current
    val height = conf.screenHeightDp.dp

    LaunchedEffect(viewModel) {
        viewModel.searchNoteById(id)
    }

    print("Note: ${viewModel.currentNote}")
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(height / 12)
        ) {
            Text(
                text = "Edit", color = Color.Blue.copy(alpha = 0.8f), modifier = Modifier
                    .align(
                        Alignment.CenterEnd
                    )
                    .padding(4.dp)
                    .clickable { navController.navigate(NavRoutes.EditNote.route) }
            )
        }
        Spacer(modifier = Modifier.height(15.dp))

        Text(text = "Title", modifier = Modifier.padding(5.dp))
        Surface(modifier = Modifier
            .fillMaxWidth()
            .height(intrinsicSize = IntrinsicSize.Max)
            .padding(5.dp),
            color = Color.LightGray.copy(alpha = 0.3f),
            shape = RoundedCornerShape(5.dp)) {
            Text(text = viewModel.currentNote?.title ?: "Note not loaded yet",
                modifier = Modifier.padding(4.dp),
                    fontWeight = FontWeight.Normal,
                    fontSize = 30.sp,
                    letterSpacing = 0.25.sp
                )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Text(text = "Description", modifier = Modifier.padding(5.dp))
        Surface(modifier = Modifier
            .fillMaxWidth()
            .height(intrinsicSize = IntrinsicSize.Max)
            .padding(start = 5.dp, end = 5.dp), color = Color.LightGray.copy(alpha = 0.3f)) {
            Text(text = viewModel.currentNote?.description ?: "Note not loaded yet",
                modifier = Modifier.padding(4.dp),
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                letterSpacing = 0.15.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}