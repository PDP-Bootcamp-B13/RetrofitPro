package dev.ogabek.retrofitpro.network.service

import dev.ogabek.retrofitpro.model.Event
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EventService {

    @GET("api/activity/")
    fun getRandom(): Call<Event>

    @GET("api/activity")
    fun getEventByKey(@Query("key") key: String): Call<Event>

    @GET("api/activity")
    fun getEventByType(@Query("type") type: String): Call<Event>

    @GET("api/activity")
    fun getEventByParticipants(@Query("participants") participants: String): Call<Event>
}