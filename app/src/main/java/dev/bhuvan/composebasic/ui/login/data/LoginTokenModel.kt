package dev.bhuvan.composebasic.ui.login.data

import com.google.gson.annotations.SerializedName
import dev.bhuvan.composebasic.data.TokenModel

data class LoginTokenModel(
    @SerializedName("access")
    val accessToken: TokenModel?,
    @SerializedName("refresh")
    val refreshToken: TokenModel?,
)
