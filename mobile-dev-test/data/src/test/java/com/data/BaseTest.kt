package com.data

import com.data.api.NewsApiService
import com.data.api.HttpClient
import com.data.api.LoggingInterceptor
import com.data.api.MoshiCreator
import com.data.utils.NewsRequestDispatcher
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

open class BaseTest {

    private lateinit var mockWebServer: MockWebServer

    private lateinit var okHttpClient: OkHttpClient

    private lateinit var loggingInterceptor: HttpLoggingInterceptor

    private lateinit var moshi: Moshi

    lateinit var apiService: NewsApiService

    @Before
    open fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher =
            NewsRequestDispatcher()
        mockWebServer.start()
        loggingInterceptor = LoggingInterceptor.create()
        okHttpClient = HttpClient.create(loggingInterceptor)
        moshi = MoshiCreator.create()

        apiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/newsapi.org/v2/"))
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(NewsApiService::class.java)
    }

    @After
    open fun tearDown() {
        mockWebServer.shutdown()
    }
}
