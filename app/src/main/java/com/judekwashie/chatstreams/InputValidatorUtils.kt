package com.judekwashie.chatstreams

fun isValidateInput(
    username: String = "",
    email: String = "",
    password: String = ""
): Boolean {
    val pattern = Regex("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
    if (username.isEmpty() || email.isEmpty() || password.isEmpty()){
        return false
    }
    if (!pattern.matches(email)){
        return false
    }
    if(password.length < 8){
        return false
    }
    return true
}