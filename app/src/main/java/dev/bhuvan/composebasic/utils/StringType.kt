package dev.bhuvan.composebasic.utils

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class StringType {
    class Resource(@StringRes val id: Int, vararg val args: Any) : StringType()
    data class Raw(val value: String) : StringType()

    companion object {
        val EMPTY = Raw("")
    }
}

@Composable
fun StringType.getString(): String = when (this) {
    is StringType.Raw -> value
    is StringType.Resource -> stringResource(id = id, *args)
}

fun Double.roundOff() : String = (Math.round(this!! * 10.0) / 10.0).toString()
