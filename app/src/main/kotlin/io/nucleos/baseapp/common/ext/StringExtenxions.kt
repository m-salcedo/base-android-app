package io.nucleos.baseapp.common.ext

import java.util.regex.Pattern

fun String?.empty() = this == null || this.trim().isEmpty()

fun String.isEmail(): Boolean {
    val regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
    val pattern = Pattern.compile(regex)
    val matcher = pattern.matcher(this)
    return matcher.matches()
}
