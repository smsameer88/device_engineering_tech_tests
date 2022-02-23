package com.data.repo

import com.data.BaseTest
import com.data.repo.NewsRepository
import com.data.source.NewsSource
import com.domain.repo.INewsDataRepository
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class NewsRepositoryTest : BaseTest() {

    private lateinit var iNewsDataRepository: INewsDataRepository

    @Before
    override fun setup() {
        super.setup()
        val mockCyrptoSource = NewsSource(apiService)
        iNewsDataRepository = NewsRepository(mockCyrptoSource)
    }

    @Test
    fun `when get list return a valid list with data`() {
        runBlocking {
            val response = iNewsDataRepository.getNews()

            response.collect {
                Truth.assertThat(it?.articles?.size).isEqualTo(5)
                Truth.assertThat(it?.articles?.get(0)?.author).isEqualTo("Chris Teague")
                Truth.assertThat(it?.articles?.get(0)?.description)
                    .isEqualTo("As it expands its charging footprint, Tesla is looking to offer additional services at its locations to appease waiting drivers.")
            }
        }
    }
}
