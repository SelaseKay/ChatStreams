package com.judekwashie.chatstreams.ui.components

import android.graphics.Color.parseColor
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(buttonText: String, onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .height(32.dp)
            .padding(
                start = 32.dp,
                end = 32.dp,
            )
            .fillMaxWidth(),
        onClick = onClick,
        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults
            .buttonColors(
                backgroundColor = Color(parseColor("#9789EA"))
            ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = buttonText,
            style = MaterialTheme.typography.body2,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}