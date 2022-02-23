package com.news.ui

import com.news.BaseViewModelTest
import com.cleanarchitecturenews.mappers.toDomain
import com.cleanarchitecturenews.ui.NewsViewModel
import com.news.utils.fakeComments
import com.news.utils.fakeLikes
import com.news.utils.fakeNews
import com.news.utils.observeOnce
import com.domain.usecases.GetAllNewsUseCase
import com.domain.usecases.GetCommentsUseCase
import com.domain.usecases.GetLikesUseCase
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class NewsViewModelTest : BaseViewModelTest() {

    @Mock
    lateinit var getAllNewsUseCase: GetAllNewsUseCase

    @Mock
    lateinit var getLikesUseCase: GetLikesUseCase

    @Mock
    lateinit var getCommentsUseCase: GetCommentsUseCase

    private lateinit var newsViewModel: NewsViewModel

    @Before
    fun setup() {
        newsViewModel = NewsViewModel(getAllNewsUseCase, getLikesUseCase, getCommentsUseCase)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `call to api should return news list`() {
        runBlockingTest {

            given(getAllNewsUseCase()).willReturn(flow {
                emit(fakeNews.toDomain())
            })

            given(getLikesUseCase("https://cn-news-info-api.herokuapp.com/likes/www.cnbc.com-2022-02-22-macys-m-reports-q4-2021-earnings.html"))
                .willReturn(
                    flow {
                        emit(fakeLikes.toDomain())
                    })

            given(getCommentsUseCase("https://cn-news-info-api.herokuapp.com/comments/www.cnbc.com-2022-02-22-macys-m-reports-q4-2021-earnings.html"))
                .willReturn(
                    flow {
                        emit(fakeComments.toDomain())
                    })

        }

        newsViewModel.getAllCoins()

        newsViewModel.newList.observeOnce {
            Truth.assertThat(it).isEqualTo(fakeNews)
        }

        newsViewModel.likesList.observeOnce {
            Truth.assertThat(it).isEqualTo(fakeLikes)
        }

        newsViewModel.commentsList.observeOnce {
            Truth.assertThat(it).isEqualTo(fakeComments)
        }
    }
}

