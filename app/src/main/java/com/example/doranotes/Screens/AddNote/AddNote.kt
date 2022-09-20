package com.example.doranotes.Screens.AddNote

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
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
fun AddNote(mainViewModel: MainViewModel,navHostController: NavHostController) {
    val focusManager = LocalFocusManager.current

    val conf = LocalConfiguration.current
    val height = conf.screenHeightDp.dp

    val context = LocalContext.current
    val title = rememberSaveable { mutableStateOf("") }
    val descr = rememberSaveable { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(4.dp)
        ) {

            Box(modifier = Modifier.fillMaxWidth().height(height/12), contentAlignment = Alignment.Center) {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Cancel",
                        modifier = Modifier
                            .clickable {
                                navHostController.navigate(NavRoutes.HomeScreen.route)
                            }
                            .padding(3.dp),
                        color = Color.Blue.copy(alpha = 0.8f))
                    Text(text = "Add Note", color = Color.Gray)
                    Text(text = "Done",
                        modifier = Modifier
                            .clickable {
                                if ((title.value.isNotEmpty() && descr.value.isNotEmpty())){
                                    mainViewModel.insert(Note(title = title.value, description = descr.value))
                                    Toast.makeText(context,"Note Saved",Toast.LENGTH_LONG).show()
                                    navHostController.navigate(NavRoutes.HomeScreen.route)
                                    title.value = ""
                                    descr.value = ""

                                }else{
//                                    Toast.makeText(context,"Both Field Must Not be Empty",Toast.LENGTH_SHORT).show()
                                    navHostController.navigate(NavRoutes.HomeScreen.route)
                                }
                            }
                            .padding(3.dp),
                        color = Color.Blue.copy(alpha = 0.8f))
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(value = title.value, onValueChange = { title.value = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Title", fontSize = 23.sp) },
                colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.Transparent),
                textStyle = TextStyle(fontSize = 24.sp),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(focusDirection = FocusDirection.Down) }),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(value = descr.value, onValueChange = { descr.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f),
                placeholder = { Text(text = "Description", fontSize = 23.sp) },
                colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.Transparent),
                textStyle = TextStyle(fontSize = 22.sp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Button(onClick = {
                if (title.value.isNotEmpty() && descr.value.isNotEmpty()){
                    mainViewModel.insert(Note(title = title.value, description = descr.value))
                    title.value = ""
                    descr.value = ""
                    Toast.makeText(context,"Note Saved",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(context,"Both Field Must Not be Empty",Toast.LENGTH_SHORT).show()
                }
            }) {
                Text(text = "Save")
            }
        }
    }
}