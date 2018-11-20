package com.omniumlab.gotpedia.data

import com.omniumlab.gotpedia.data.dto.BookDTO
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface IceAndFireService {
    @GET("books")
    fun listBooks(): Call<List<BookDTO>>

    object Factory {
        private const val BASE_URL = "https://anapioficeandfire.com/api/"

        fun makeRetrofitService(): IceAndFireService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build().create(IceAndFireService::class.java)
        }
    }
}