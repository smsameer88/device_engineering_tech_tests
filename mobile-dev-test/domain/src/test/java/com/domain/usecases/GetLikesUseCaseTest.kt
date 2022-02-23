package com.domain.usecases

import com.domain.repo.INewsDataRepository
import com.domain.usecases.GetLikesUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetLikesUseCaseTest {

    @Mock
    private lateinit var iNewsDataRepository: INewsDataRepository

    lateinit var getLikesUseCase: GetLikesUseCase

    @Before
    fun setup() {
        getLikesUseCase = GetLikesUseCase(iNewsDataRepository)
    }

    @Test
    fun `when request likes get all likes`() {
        runBlocking {
            //Get likes
            getLikesUseCase("https://cn-news-info-api.herokuapp.com/likes/www.cnbc.com-2022-02-22-macys-m-reports-q4-2021-earnings.html")

            // verify that there is data
            Mockito.verify(iNewsDataRepository)
                .getLikes("https://cn-news-info-api.herokuapp.com/likes/www.cnbc.com-2022-02-22-macys-m-reports-q4-2021-earnings.html")
        }
    }
}
