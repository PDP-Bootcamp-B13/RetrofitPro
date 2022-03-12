package dev.ogabek.retrofitpro.network

import dev.ogabek.retrofitpro.network.service.EventService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHttp {

    companion object {

        private val TAG: String = RetrofitHttp::class.java.simpleName

        const val IS_TESTER = true;

        private const val SERVER_DEVELOPMENT = "http://www.boredapi.com/"
        private const val SERVER_PRODUCTION = "http://www.boredapi.com/"

        private fun server(): String {
            return if (IS_TESTER) {
                SERVER_DEVELOPMENT
            } else {
                SERVER_PRODUCTION
            }
        }

        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(server())
                .build()
        }

        val eventService: EventService = getRetrofit().create(EventService::class.java)

    }

}