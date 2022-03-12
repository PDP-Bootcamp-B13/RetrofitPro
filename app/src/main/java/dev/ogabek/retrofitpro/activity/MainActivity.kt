package dev.ogabek.retrofitpro.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import dev.ogabek.retrofitpro.R
import dev.ogabek.retrofitpro.model.Event
import dev.ogabek.retrofitpro.network.RetrofitHttp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val TAG: String = MainActivity::class.java.simpleName
    var event = Event()

    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.text)

        initViews()

        Toast.makeText(this, event.toString(), Toast.LENGTH_SHORT).show()


    }

    private fun initViews() {

        RetrofitHttp.eventService.getRandom().enqueue(object: Callback<Event>{
            override fun onResponse(call: Call<Event>, response: Response<Event>) {
                if (response.body() != null) {
                    Log.d(TAG, response.body().toString())
                    event = response.body()!!
                    text.text = event.toString()
                } else {
                    Log.e(TAG, "Response is null")
                }
            }

            override fun onFailure(call: Call<Event>, t: Throwable) {
                Log.e(TAG, t.localizedMessage.toString())
            }

        })
    }
}