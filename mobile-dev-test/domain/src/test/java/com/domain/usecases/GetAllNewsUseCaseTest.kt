package com.domain.usecases

import com.domain.repo.INewsDataRepository
import com.domain.usecases.GetAllNewsUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetAllNewsUseCaseTest {

    @Mock
    private lateinit var iNewsDataRepository: INewsDataRepository

    lateinit var getAllNewsUseCase: GetAllNewsUseCase

    @Before
    fun setup() {
        getAllNewsUseCase = GetAllNewsUseCase(iNewsDataRepository)
    }

    @Test
    fun `when request news get all news`() {
        runBlocking {
            // Get all news
            getAllNewsUseCase()

            // verify that there is data
            Mockito.verify(iNewsDataRepository).getNews()
        }
    }
}
