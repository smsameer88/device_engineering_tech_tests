package com.data.models

import com.data.utils.commentsEntity
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CommentsEntityTest {

    private lateinit var commentsEntityModel: CommentsEntity

    @Test
    fun `instantiate object check proper class and content`() {
        commentsEntityModel = commentsEntity()

        val copy = commentsEntityModel.copy()

        assertThat(copy).isEqualTo(commentsEntityModel)

        assertThat(commentsEntityModel).isInstanceOf(CommentsEntity::class.java)
    }
}
