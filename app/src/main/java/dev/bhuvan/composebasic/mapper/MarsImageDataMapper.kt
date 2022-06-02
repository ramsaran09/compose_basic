package dev.bhuvan.composebasic.mapper

import dev.bhuvan.composebasic.model.MarsImageDataModel
import dev.bhuvan.composebasic.model.MarsPhotoModel
import dev.bhuvan.composebasic.responsehandler.CustomResponse
import dev.bhuvan.composebasic.responsehandler.LocalException
import dev.bhuvan.composebasic.constants.ERROR_SERVER
import retrofit2.Response


object MarsImageDataMapper {

    fun map(marsDataResponse: Response<MarsPhotoModel>): CustomResponse<ArrayList<MarsImageDataModel>, LocalException> {
        return if (marsDataResponse.isSuccessful && marsDataResponse.code() == 200) {
            CustomResponse.Success(marsDataResponse.body()?.photos ?: arrayListOf())
        } else CustomResponse.Failure(LocalException(ERROR_SERVER))
    }
}