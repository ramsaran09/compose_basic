package dev.bhuvan.composebasic.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.component.KoinComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiProvider : KoinComponent{

    private const val BASE_URL = "https://api.nasa.gov/"

    val onlineInterceptor = Interceptor{ chain ->
        val response = chain.proceed(chain.request())
        val maxAge = 60
        return@Interceptor response.newBuilder()
            .header("Cache-Control", "public, max-age=$maxAge")
            .removeHeader("Pragma")
            .build()
    }

    private fun loggingInterceptor() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    private fun httpClient() =
        OkHttpClient.Builder().apply {
            addInterceptor(loggingInterceptor())
            addNetworkInterceptor(onlineInterceptor)
        }.build()

    private val retrofit = Retrofit.Builder().apply {
        baseUrl(BASE_URL)
        addConverterFactory(GsonConverterFactory.create())
        client(httpClient())
    }.build()

    val client : ServiceApi by lazy { retrofit.create(ServiceApi::class.java) }

}