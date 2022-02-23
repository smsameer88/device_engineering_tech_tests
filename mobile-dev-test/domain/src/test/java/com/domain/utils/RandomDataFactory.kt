package com.domain.utils

import com.domain.models.*

internal fun news() = News(
    "ok", 7604, listOf(
        Article(
            Source("techradar", "TechRadar"),
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

internal fun likes() = Likes(16)

internal fun comments() = Comments(9)