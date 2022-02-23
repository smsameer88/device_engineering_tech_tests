package com.data.source

import com.data.BaseTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class NewsSourceTest : BaseTest() {

    private lateinit var newsSource: NewsSource

    @Before
    override fun setup() {
        super.setup()
        newsSource = NewsSource(apiService)
    }

    @Test
    fun `when get list return a valid list with data`() {
        runBlocking {
            val response = newsSource.getAllNews()

            response.collect {
                assertThat(it!!.articles?.size).isEqualTo(5)
                assertThat(it.articles?.get(0)?.author).isEqualTo("Chris Teague")
                assertThat(it.articles?.get(0)?.description).isEqualTo("As it expands its charging footprint, Tesla is looking to offer additional services at its locations to appease waiting drivers.")
            }
        }
    }
}
