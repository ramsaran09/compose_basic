package dev.bhuvan.composebasic.ui.document.data

import com.google.gson.annotations.SerializedName

data class DocumentListResponse(
    @SerializedName("status_code")
    val statusCode: Int?,
    @SerializedName("status")
    val status: Boolean?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("totalDoc")
    val totalDoc: Int?,
    @SerializedName("totalPages")
    val totalPages: Int?,
    @SerializedName("currentPage")
    val currentPage: Int?,
    @SerializedName("data")
    val documentList: ArrayList<DocumentItem?>?,
)

data class DocumentItem(
    @SerializedName("_id")
    var documentId: String?,

    @SerializedName("type")
    val type: String?,

    @SerializedName("name")
    var name: String?,

    @SerializedName("url")
    var url: String?,

    @SerializedName("_course_id")
    val courseId: String?,

    @SerializedName("createdAt")
    val createdAt: String?,

    @SerializedName("updatedAt")
    val updatedAt: String?,

    @SerializedName("courseDetail")
    val courseDetail: DocumentCourseDetail?,

    @SerializedName("UploadedBy")
    val userDetail: DocumentUserDetail?,

    @SerializedName("starred")
    var starred: Boolean?,

    @SerializedName("courseAdmin")
    var courseAdmin: Boolean?,

    @SerializedName("sessions")
    var sessions: ArrayList<SessionForUser?>?,
    @SerializedName("createdBy")
    var createdBy: String?,
    @SerializedName("updatedDate")
    var updatedDate: String?,
    @SerializedName("sessionsName")
    var sessionsName: String?,
    @SerializedName("selected")
    var isSelected: Boolean?
)

data class DocumentCourseDetail(
    @SerializedName("_id")
    val id: String?,
    @SerializedName("_course_id")
    val courseId: String?,
    @SerializedName("course_name")
    val courseName: String?,
    @SerializedName("course_code")
    val courseCode: String?,
)

data class DocumentUserDetail(
    @SerializedName("_id")
    var staffId: String?,

    @SerializedName("name")
    var name: NameModel?,
)

data class NameModel (
    @SerializedName("first")
    var first: String? = null,

    @SerializedName("last")
    var last: String? = null,

    @SerializedName("middle")
    var middle: String? = null,

    @SerializedName("family")
    var family: String? = null,
)

data class SessionForUser(
    @SerializedName("_id")
    val id: String?,
    @SerializedName("_session_id")
    val sessionId: String?,
    @SerializedName("delivery_symbol")
    val deliverySymbol: String?,
    @SerializedName("session_type")
    val sessionType: String?,
    @SerializedName("session_topic")
    val sessionTopic: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("s_no")
    val sNo: Int?,
    @SerializedName("delivery_no")
    val deliveryNo: Int?,
)