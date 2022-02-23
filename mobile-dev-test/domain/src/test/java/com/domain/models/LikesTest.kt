package com.domain.models

import com.domain.utils.likes
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class LikesTest {

    private lateinit var likesModel: Likes

    @Test
    fun `instantiate object check proper class and content`() {
        likesModel = likes()

        val copy = likesModel.copy()

        assertThat(copy).isEqualTo(likesModel)

        assertThat(likesModel).isInstanceOf(Likes::class.java)
    }
}
