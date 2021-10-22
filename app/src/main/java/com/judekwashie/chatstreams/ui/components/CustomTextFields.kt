package com.judekwashie.chatstreams.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import android.graphics.Color.parseColor
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(
    hint: String,
    marginTop: Dp,
    isPasswordField: Boolean = false,
    leadingIcon: ImageVector

) {
    var text by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier
            .padding(start = 32.dp, end = 32.dp, top = marginTop)
            .fillMaxWidth(),
        placeholder = {
            Text(
                hint,
                style = MaterialTheme.typography.body1,
                color = Color(parseColor("#DCDCDC")),
            )
        },
        keyboardOptions = if (isPasswordField) KeyboardOptions(keyboardType = KeyboardType.Password) else KeyboardOptions(
            keyboardType = KeyboardType.Email
        ),
        trailingIcon = {
            val image =
                if (isPasswordField && passwordVisibility)
                    Icons.Outlined.Visibility
                else if (isPasswordField && !passwordVisibility) Icons.Outlined.VisibilityOff
                else null

            image?.let {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(imageVector = it, "")
                }
            }
        },
        visualTransformation = if (isPasswordField) {
            if (passwordVisibility)
                VisualTransformation.None
            else
                PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                "",
                tint = Color(parseColor("#DCDCDC")),
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            disabledIndicatorColor = Color(parseColor("#DCDCDC")),
            focusedIndicatorColor = Color(parseColor("#BEBEBE")),
            unfocusedIndicatorColor = Color(parseColor("#DCDCDC")),
            cursorColor = Color.Black
        ),
        singleLine = true,
    )

}