package com.example.consultarest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.consultarest.Request.RequestApi
import com.example.consultarest.Response.ExchangeResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val retrofit = Retrofit.Builder().baseUrl("https://api.exchangeratesapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    private val postsApi = retrofit.create(RequestApi::class.java)
    private val response = postsApi.getAllPosts()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        response.enqueue(object : Callback<ExchangeResponse> {
            override fun onFailure(call: Call<ExchangeResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<ExchangeResponse>, response: Response<ExchangeResponse>) {
                val mRespuesta = response.body()
                usd_texto.text = "USD: ${mRespuesta!!.rates!!.USD.toString()}"
                rub_texto.text = "RUB: ${mRespuesta!!.rates!!.RUB.toString()}"


            }

        })

    }
}
