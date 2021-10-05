package com.judekwashie.chatstreams.ui.screens.components

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import android.graphics.Color.parseColor
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun NavigationText(
    infoText: String,
    navigationText: String,
    onClick: ()-> Unit
) {
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color(parseColor("#858585")),
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                fontStyle = MaterialTheme.typography.subtitle1.fontStyle
            )
        ) {
            append(infoText)
        }


        // We attach this *URL* annotation to the following content
        // until `pop()` is called
        pushStringAnnotation(
            tag = navigationText,
            annotation = navigationText
        )
        withStyle(
            style = SpanStyle(
                color = Color(parseColor("#0085FF")),
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                fontStyle = MaterialTheme.typography.subtitle1.fontStyle
            )
        ) {
            append(navigationText)
        }

        pop()
    }

    ClickableText(
        style = TextStyle(
            textAlign = TextAlign.Right
        ),
        modifier = Modifier
            .padding(
                top = 24.dp,
                end = 32.dp
            )
            .fillMaxWidth(),
        text = annotatedText,
        onClick = { offset ->
            // We check if there is an *URL* annotation attached to the text
            // at the clicked position
            annotatedText.getStringAnnotations(
                tag = navigationText, start = offset,
                end = offset
            )
                .firstOrNull()?.let { annotation ->
                    onClick()
                }
        }
    )
}