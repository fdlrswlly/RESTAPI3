package com.fadhlyaulia.restapi3

import retrofit2.Call
import retrofit2.http.*

interface ServiceInterface {
    @GET("Kontak")
    fun getData(): Call<List<KontakData>>
    @POST("Kontak")
    fun postKontak(@Body kontakData: KontakData): Call<KontakData>

}
