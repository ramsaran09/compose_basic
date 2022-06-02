package dev.bhuvan.composebasic.network

import dev.bhuvan.composebasic.model.MarsPhotoModel
import retrofit2.Response
import retrofit2.http.GET


interface ServiceApi {

    @GET("mars-photos/api/v1/rovers/curiosity/photos?sol=50&page=1&api_key=iZljFGraa5IhFpUhu2NXuzqphZf6zhXgXbvwzdWA")
    suspend fun getMarsImages() : Response<MarsPhotoModel>

}