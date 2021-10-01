package com.judekwashie.chatstreams.ui.screens.components

import android.graphics.Color.parseColor
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeText() {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    fontStyle = MaterialTheme.typography.body1.fontStyle
                )
            ) {
                append("WELCOME TO\n")
            }
            withStyle(
                style = SpanStyle(
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = MaterialTheme.typography.h1.fontStyle
                )
            ) {
                append("chat")
            }
            withStyle(
                style = SpanStyle(
                    color = Color(parseColor("#9789EA")),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = MaterialTheme.typography.h1.fontStyle
                )
            ) {
                append("STREAMS")
            }
        },
        modifier = Modifier.padding(
            start = 32.dp,
            top = 62.dp
        ),
        lineHeight = 40.sp
    )
}