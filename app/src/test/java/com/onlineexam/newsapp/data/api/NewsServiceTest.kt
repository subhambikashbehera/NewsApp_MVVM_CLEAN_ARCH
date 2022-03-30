package com.onlineexam.newsapp.data.api

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(AndroidJUnit4::class)
class NewsServiceTest {

    private lateinit var newsService: NewsService
    private lateinit var server:MockWebServer


    @Before
    fun setUp() {
        server= MockWebServer()
        newsService=Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsService::class.java)
    }


    private fun enqueueMockResponse(
        fileName:String
    ){
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getTopHeadings() {
        runBlocking {
            enqueueMockResponse("ApiResponse.json")
            val responseBody=newsService.getHeading("us",1).body()
            val request=server.takeRequest()
            Truth.assertThat(responseBody).isNotNull()
        }
    }



    @After
    fun tearDown() {
       server.shutdown()
    }
}