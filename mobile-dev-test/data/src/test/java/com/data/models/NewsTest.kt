package com.data.models

import com.data.utils.newsEntity
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class NewsTest {

    private lateinit var newsEntityModel: NewsEntity

    @Test
    fun `instantiate object check proper class and content`() {
        newsEntityModel = newsEntity()

        val copy = newsEntityModel.copy()

        assertThat(copy).isEqualTo(newsEntityModel)

        assertThat(newsEntityModel).isInstanceOf(NewsEntity::class.java)
    }
}
