package com.example.appdevelopproject.retrofitbookapp

fun String?.isJsonObject():Boolean {
    return this?.startsWith("{") == true && this.endsWith("}")
}

fun String?.isJsonArray():Boolean {
    return this?.startsWith("[") == true && this.endsWith("]")
}