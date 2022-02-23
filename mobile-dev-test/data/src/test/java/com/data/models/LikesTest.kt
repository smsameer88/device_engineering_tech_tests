package com.data.models

import com.data.utils.likesEntity
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class LikesTest {

    private lateinit var likesEntityModel: LikesEntity

    @Test
    fun `instantiate object check proper class and content`() {
        likesEntityModel = likesEntity()

        val copy = likesEntityModel.copy()

        assertThat(copy).isEqualTo(likesEntityModel)

        assertThat(likesEntityModel).isInstanceOf(LikesEntity::class.java)
    }
}
