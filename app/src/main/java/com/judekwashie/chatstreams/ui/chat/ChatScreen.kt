package com.judekwashie.chatstreams.ui.chat

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import android.graphics.Color.parseColor
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.judekwashie.chatstreams.R
import com.judekwashie.chatstreams.data.Message
import com.judekwashie.chatstreams.ui.theme.fonts

@Composable
fun ChatScreen(chatViewModel: ChatViewModel = viewModel()) {

    val messages = chatViewModel.messages.value
    Log.i("ChatScreen", "$messages")
    Log.i("ChatScreen", "$messages")
    Log.i("ChatScreen", "$messages")

    Scaffold(
        topBar = {
            ChatAppBar()
        }
    ) {
        ChatScreenBody(messages, chatViewModel)
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
        elevation = 3.dp
    )
}

@Composable
private fun ChatScreenBody(messages: ArrayList<Message>, chatViewModel: ChatViewModel) {

    Column(
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp
            )
            .fillMaxSize(),
//        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Box(modifier = Modifier.fillMaxHeight(0.8f)) {
            Text("Hello World")
//            LazyColumn(
//                modifier = Modifier.fillMaxSize()
//                    .background(color = Color.Blue),
//            ) {
//                itemsIndexed(
//                    items = messages,
//                ) { index, item ->
//                    MessageCard(message = item.msg,
//                        messageOwner = "",
//                        messageTime = "",
//                        messageDate = "",
//                        cardColor = 0xff9789EA)
//                }
//
//            }
        }



        MessageComponent(
            Modifier
                .fillMaxWidth()
                .fillMaxSize(2f)
                .padding(bottom = 8.dp),
            chatViewModel
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
private fun MessageTextField(
    modifier: Modifier,
    onTextChange: (textInput: String) -> Unit,
) {
    var text by remember {
        mutableStateOf("")
    }

    Box(modifier = modifier) {
        BasicTextField(
            modifier = modifier,
            value = text,
            onValueChange = {
                text = it
                onTextChange(text)
            },
            maxLines = 4,
            decorationBox = { innerTextField ->
                Row(
                    Modifier
                        .background(
                            Color(0xffEAEAEA),
                            RoundedCornerShape(32.dp)
                        )
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
private fun SendButton(sendMessage: () -> Unit) {
    FloatingActionButton(
        modifier = Modifier
            .size(48.dp),
        onClick = sendMessage,
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
private fun MessageComponent(
    modifier: Modifier,
    chatViewModel: ChatViewModel
) {
    var inputText by remember {
        mutableStateOf("")
    }
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.Bottom
    ) {

        MessageTextField(
            modifier = Modifier
                .heightIn(48.dp)
                .weight(0.8f, fill = true)
                .fillMaxWidth()
        ) {
            inputText = it
        }

        Spacer(modifier = Modifier.width(8.dp))

        SendButton {
            chatViewModel.sendMessage(Message(msg = inputText))
        }


    }
}

//Message card components
@Composable
private fun MessageCard(
    message: String,
    messageOwner: String,
    messageTime: String,
    messageDate: String,
    cardColor: Long,

    ) {
    Column {
        Card(
            modifier = Modifier.background(
                color = Color(cardColor)
            ),
            shape = RoundedCornerShape(
                topStart = 16.dp,
                topEnd = 4.dp,
                bottomStart = 16.dp,
                bottomEnd = 16.dp
            )
        ) {
            Column(
                modifier = Modifier.padding(
                    start = 8.dp,
                    end = 8.dp
                )
            ) {
                MessageOwner(name = messageOwner)
                Text(
                    message,
                    modifier = Modifier.padding(top = 8.dp)
                )
                MessageTime(time = messageTime)

            }
        }
        MessageDate(date = messageDate)
    }


}

@Composable
private fun MessageTime(time: String) {
    Text(
        time,
        modifier = Modifier.fillMaxSize(),
        fontSize = 12.sp,
        color = Color(0xff3E2BA6),
        textAlign = TextAlign.Right
    )
}

@Composable
private fun MessageDate(date: String) {
    Text(
        date,
        modifier = Modifier.fillMaxSize(),
        fontSize = 12.sp,
        textAlign = TextAlign.Right
    )
}

@Composable
private fun MessageOwner(name: String) {
    Text(
        name,
        modifier = Modifier.padding(top = 8.dp),
        fontSize = 16.sp,
        color = Color.Black
    )
}



