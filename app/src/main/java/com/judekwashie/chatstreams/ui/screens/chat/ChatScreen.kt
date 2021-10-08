package com.judekwashie.chatstreams.ui.screens.chat

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import android.graphics.Color.parseColor
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.judekwashie.chatstreams.R

@Composable
fun ChatScreen() {
    Scaffold(
        topBar = {
            ChatAppBar()
        }
    ) {
        ChatScreenBody()
    }
}

@Composable
private fun ChatAppBar() {
    TopAppBar(
        backgroundColor = Color(parseColor("#9789EA")),
        title = {
            Text(
                text = stringResource(
                    id = R.string.app_name
                ),
                style = MaterialTheme.typography.h2,
                color = Color.White
            )
        },
        elevation = 0.dp
    )
}

@Composable
private fun ChatScreenBody() {
    Column(
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp
            )
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Box(modifier = Modifier.fillMaxSize(8f)) {
            Text("Hello World")
        }

        MessageComponent(
            Modifier
                .fillMaxSize(2f)
                .padding(bottom = 8.dp)
        )

    }
}

@Composable
private fun ChatMessageScrollable() {
    Column(
        Modifier
            .verticalScroll(state = rememberScrollState())
            .fillMaxSize()
            .background(Color.Green)
    ) {

    }
}

@Composable
private fun MessageTextField(modifier: Modifier) {
    var text by remember {
        mutableStateOf("")
    }

    Box(modifier = modifier) {
        BasicTextField(
            modifier = modifier,
            value = text,
            onValueChange = { text = it },
            maxLines = 4,
            decorationBox = { innerTextField ->
                Row(
                    Modifier
                        .background(Color.LightGray, RoundedCornerShape(32.dp))
                        .padding(16.dp)
                ) {
                    innerTextField()
                }
            }
        )
        if (text.isEmpty()) {
            Text(
                text = stringResource(id = R.string.type_a_message),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp)
                    .align(alignment = Alignment.CenterStart),
                style = MaterialTheme.typography.caption,
                color = Color(0xff969696)
            )
        }
    }


}


@Composable
private fun SendButton(modifier: Modifier) {
    FloatingActionButton(
        modifier = Modifier
            .size(48.dp),
        onClick = { /*TODO*/ },
        backgroundColor = Color(parseColor("#2094FF"))

    ) {
        Icon(
            Icons.Filled.Send,
            "",
            tint = Color.White
        )
    }
}

@Composable
private fun MessageComponent(modifier: Modifier) {
    Row(
        modifier = modifier,
    ) {

        MessageTextField(
            modifier = Modifier
                .heightIn(48.dp)
                .weight(0.8f, fill = true)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.width(8.dp))

        SendButton(
            modifier = Modifier
                .size(48.dp)
                .weight(0.2f),
        )


    }
}