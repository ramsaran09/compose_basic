package dev.bhuvan.composebasic.ui.login.data

import com.google.gson.annotations.SerializedName
import dev.bhuvan.composebasic.ui.login.data.LoginDataModel

data class LoginResponse(
    @SerializedName("status_code")
    val statusCode: Int?,

    @SerializedName("status")
    val status: Boolean?,

    @SerializedName("message")
    val message: String?,

    @SerializedName("data")
    val data: LoginDataModel?,
)
