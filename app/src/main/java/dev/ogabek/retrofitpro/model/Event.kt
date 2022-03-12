package dev.ogabek.retrofitpro.model

data class Event(
    val activity: String = "",
    val type: String = "",
    val participants: Long = 0,
    val price: Float = 0F,
    val link: String = "",
    val key: String = ""
)
