package dev.bhuvan.composebasic.repository

import dev.bhuvan.composebasic.mapper.MarsImageDataMapper
import dev.bhuvan.composebasic.model.MarsImageDataModel
import dev.bhuvan.composebasic.network.ServiceApi
import dev.bhuvan.composebasic.responsehandler.CustomResponse
import dev.bhuvan.composebasic.responsehandler.LocalException

class MarsImageRepository(
    private val serviceApi: ServiceApi
) {

    suspend fun getMarsImageDataFromServer(): CustomResponse<ArrayList<MarsImageDataModel>, LocalException> =
        MarsImageDataMapper.map(serviceApi.getMarsImages())

}