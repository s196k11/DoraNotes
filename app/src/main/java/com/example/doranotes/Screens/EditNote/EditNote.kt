package com.example.doranotes.Screens.EditNote

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.doranotes.MainViewModel.MainViewModel
import com.example.doranotes.Model.Note
import com.example.doranotes.Navigation.NavRoutes

@Composable
fun EditNote(viewModel: MainViewModel,navController : NavHostController){
    val conf = LocalConfiguration.current
    val height = conf.screenHeightDp.dp

    val focusManager = LocalFocusManager.current

    val title = rememberSaveable { mutableStateOf(viewModel.currentNote?.title.toString())}
    val desc = rememberSaveable { mutableStateOf(viewModel.currentNote?.description.toString())}


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(height / 12)
        ) {
            Text(
                text = "Save", color = Color.Blue.copy(alpha = 0.8f), modifier = Modifier
                    .align(
                        Alignment.CenterEnd
                    )
                    .padding(4.dp)
                    .clickable { navController.navigate(NavRoutes.HomeScreen.route) }
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(value = title.value, onValueChange = {title.value = it  },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {  },
            colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.Transparent),
            textStyle = TextStyle(fontSize = 24.sp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(focusDirection = FocusDirection.Down) }),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = desc.value, onValueChange = { desc.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
            placeholder = { Text(text = "Description", fontSize = 23.sp) },
            colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.Transparent),
            textStyle = TextStyle(fontSize = 22.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Button(onClick = {
            viewModel.update(title = title.value, description = desc.value,id = viewModel.currentNote?.Id?.toInt())
            navController.navigate(NavRoutes.HomeScreen.route)
            title.value = ""
            desc.value = ""
        }) {
            Text(text = "Save")
        }
    }
}
