package dev.bhuvan.composebasic.ui.login.data

import com.google.gson.annotations.SerializedName

data class LoginDataModel(
    @SerializedName("_id")
    var staffId: String?,

    @SerializedName("email")
    var email: String?,

    @SerializedName("tokens")
    val tokens: LoginTokenModel?,

    @SerializedName("superAdmin")
    val superAdmin: Boolean?,
)