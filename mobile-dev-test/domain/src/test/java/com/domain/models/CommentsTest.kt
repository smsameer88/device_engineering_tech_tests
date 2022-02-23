package com.domain.models

import com.domain.utils.comments
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CommentsTest {

    lateinit var commentsModel: Comments

    @Test
    fun `instantiate object check proper class and content`() {
        commentsModel = comments()

        val copy = commentsModel.copy()

        assertThat(copy).isEqualTo(commentsModel)

        assertThat(commentsModel).isInstanceOf(Comments::class.java)
    }
}
