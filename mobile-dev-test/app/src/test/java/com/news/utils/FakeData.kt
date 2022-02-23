package com.news.utils

import com.cleanarchitecturenews.models.*

val fakeNews =
    NewsUiModel(
        "ok", 7604, listOf(
            ArticleUiModel(
                SourceUiModel("techradar", "TechRadar"),
                "Chris Teague",
                "Tesla's futuristic diner and drive-in theater charging station plan is still alive",
                "As it expands its charging footprint, Tesla is looking to offer additional services at its locations to appease waiting drivers.",
                "https://www.techradar.com/news/teslas-futuristic-diner-and-drive-in-theater-charging-station-plan-is-still-alive",
                "https://cdn.mos.cms.futurecdn.net/qhpdkdHpNULbtCNH4TqkGh-1200-80.jpg",
                "2022-02-22T17:41:23Z",
                "Another day, another Tesla story, but this time the news is entertaining rather than controversial. In a recent Twitter conversation, Tesla CEO Elon Musk restated his plans to combine one of the auto… [+2156 chars]"
            )
        )
    )

val fakeLikes=
    LikesUiModel(16)

val fakeComments=
    CommentsUiModel(9)