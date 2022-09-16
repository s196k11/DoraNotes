package com.example.doranotes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.doranotes.Model.Note


@Composable
fun NoteRow(height: Dp, note: Note, onClick: () -> Unit, onRemove: () -> Unit) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(height = height / 7)
        .padding(horizontal = 4.dp, vertical = 2.dp)
        .shadow(shape = RoundedCornerShape(3.dp), elevation = 1.dp)
        .background(color = Color(0xFF26E6FF))
        .clickable { onClick()}
    ) {
        Column() {

            Text(text = note.title, fontWeight = FontWeight.Normal,
                fontSize = 25.sp,
                letterSpacing = (-0.5).sp,
                modifier = Modifier.padding(horizontal = 4.dp)
            )


            Text(text = note.description, fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                letterSpacing = 0.15.sp,
                color = Color.Gray,
                modifier = Modifier.padding(
                    horizontal = 4.dp
                ),
                overflow = TextOverflow.Ellipsis
            )

        }
        Icon(imageVector = Icons.Default.Delete,
            contentDescription = null,
            modifier = Modifier
                .align(
                    Alignment.CenterEnd)
                .padding(2.dp)
                .clickable { onRemove() }
        )
    }
}