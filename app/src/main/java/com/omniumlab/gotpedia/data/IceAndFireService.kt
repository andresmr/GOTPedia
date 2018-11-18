package com.omniumlab.gotpedia.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.omniumlab.gotpedia.data.dto.BookDTO
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface IceAndFireService {
    @GET("books")
    fun listBooks(): Deferred<Response<List<BookDTO>>>

    object Factory {
        private const val BASE_URL = "https://anapioficeandfire.com/api/"

        fun makeRetrofitService(): IceAndFireService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build().create(IceAndFireService::class.java)
        }
    }
}