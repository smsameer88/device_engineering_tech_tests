package com.domain.models

import com.domain.utils.comments
import com.domain.utils.likes
import com.domain.utils.news
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class NewsTest {

    private lateinit var newsModel: News

    lateinit var likesModel: Likes

    lateinit var commentsModel: Comments

    @Test
    fun `instantiate object check proper class and content`() {
        newsModel = news()
        likesModel= likes()
        commentsModel= comments()


        val copy = newsModel.copy()
        val copy1=likesModel.copy()
        val copy2=commentsModel.copy()

        assertThat(copy).isEqualTo(newsModel)
        assertThat(copy1).isEqualTo(likesModel)
        assertThat(copy2).isEqualTo(commentsModel)

        assertThat(newsModel).isInstanceOf(News::class.java)
        assertThat(likesModel).isInstanceOf(Likes::class.java)
        assertThat(commentsModel).isInstanceOf(Comments::class.java)
    }
}
