package dev.bhuvan.composebasic.ui.document

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.bhuvan.composebasic.ui.document.data.DocumentItem
import kotlinx.coroutines.launch

class RecentDocumentViewModel : ViewModel() {

    var searchText by mutableStateOf("")
        private set

    fun getSingleDocument(docuemntId : String) {
        viewModelScope.launch {
            //do Api
            //success ->
            //failure ->

        }
    }

    data class RecentDocumentViewModelState(
        val isLoading: Boolean? = false,
        val documentList: ArrayList<DocumentItem> = arrayListOf(),
        val url : String = "",
    ) {
        fun toUiState() =
            RecentDocumentUiState(
                isLoading = isLoading,
                documentList = documentList,
                url = url,
            )
    }
}

data class RecentDocumentUiState(
    val isLoading : Boolean?,
    val documentList : ArrayList<DocumentItem>,
    val url : String?
)