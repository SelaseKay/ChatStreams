package com.judekwashie.chatstreams.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Password
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.judekwashie.chatstreams.ui.screens.components.CustomTextField
import com.judekwashie.chatstreams.ui.screens.components.WelcomeText

@Composable
fun SignInScreen() {
    Column(
        modifier = Modifier.verticalScroll(state = rememberScrollState())
    ) {
        WelcomeText()

        CustomTextField(
            hint = "Email",
            marginTop = 56.dp,
            leadingIcon = Icons.Outlined.Email
        )

        CustomTextField(
            hint = "Password",
            marginTop = 16.dp,
            isPasswordField = true,
            leadingIcon = Icons.Outlined.Lock
        )
    }
}

