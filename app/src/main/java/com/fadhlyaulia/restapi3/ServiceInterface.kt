package com.fadhlyaulia.restapi3

import retrofit2.Call
import retrofit2.http.*

interface ServiceInterface {
    @GET("Kontak")
    fun getData(): Call<List<KontakData>>
    @POST("Kontak")
    fun postKontak(@Body kontakData: KontakData): Call<KontakData>
    @FormUrlEncoded
    @HTTP(method="PUT", path="Kontak", hasBody = true)
    fun updateKontak(
        @Field("id") id: Int,
        @Field("nama") nama: String,
        @Field("no_hp") nomor: String,
        @Field("alamat") alamat: String): Call<KontakData>
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "Kontak", hasBody = true)
    fun deleteKontak(@Field("id") id: Int): Call<KontakData>



}
