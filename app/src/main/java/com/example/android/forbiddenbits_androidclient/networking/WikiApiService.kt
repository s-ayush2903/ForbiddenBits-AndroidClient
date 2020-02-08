package com.example.android.forbiddenbits_androidclient.networking

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface WikiApiService {
    @GET("comments")
    fun hitCountCheck(
        @Query("action") action: String,
        @Query("list") list: String,
        @Query("format") format: String,
        @Query("srsearch") srsearch: String
    ): Observable<Model.Result>  //some error is here, do remove it as soon as possible


    companion object {
        fun create(): WikiApiService {
            val retrofit =
                Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://en.wikipedia.org/w/")
                    .build()
            return retrofit.create(WikiApiService::class.java)
        }
    }
}