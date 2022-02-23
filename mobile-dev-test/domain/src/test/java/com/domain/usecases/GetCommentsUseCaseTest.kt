package com.domain.usecases

import com.domain.repo.INewsDataRepository
import com.domain.usecases.GetCommentsUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetCommentsUseCaseTest {

    @Mock
    private lateinit var iNewsDataRepository: INewsDataRepository

    lateinit var getCommentsUseCase: GetCommentsUseCase

    @Before
    fun setup() {
        getCommentsUseCase = GetCommentsUseCase(iNewsDataRepository)
    }

    @Test
    fun `when request comments get comments`() {
        runBlocking {
            //Get Comments
            getCommentsUseCase("https://cn-news-info-api.herokuapp.com/comments/www.cnbc.com-2022-02-22-macys-m-reports-q4-2021-earnings.html")

            // verify that there is data
            Mockito.verify(iNewsDataRepository)
                .getComments("https://cn-news-info-api.herokuapp.com/comments/www.cnbc.com-2022-02-22-macys-m-reports-q4-2021-earnings.html")
        }
    }
}
