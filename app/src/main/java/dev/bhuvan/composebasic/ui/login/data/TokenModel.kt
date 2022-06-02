package dev.bhuvan.composebasic.data

import com.google.gson.annotations.SerializedName

data class TokenModel(
    @SerializedName("token")
    val token: String?,
    @SerializedName("expires")
    val expires: String?,
)
