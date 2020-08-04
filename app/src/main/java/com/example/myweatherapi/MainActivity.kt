package com.example.myweatherapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private val  TAG: String = "WEATHER"
    lateinit var tv1: TextView
    lateinit var tv2: TextView
    lateinit var tv3: TextView
    lateinit var im: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv1 = findViewById(R.id.tv)
        tv2 = findViewById(R.id.textView)
        tv3 = findViewById(R.id.textView2)
        im =  findViewById(R.id.image)

        val compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            RetrofitClass.bildretrofit().getWeather("Moscow","9105c08fd7019d9fa51cc2e3c79e6f76","metric")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({response -> onResponse(response)}, {t -> onFailure(t) }))
    }

    private fun onResponse(response: Weather) {
            Log.i(TAG, "KEK" )
            val weather = response
            tv3.text = "Moscow"
            tv2.text=getString(R.string.title_current_weather, weather.main.temp.toInt())
            tv1.text=getString(R.string.text_current_weather, weather?.main?.minTemp?.toInt(), weather?.main?.maxTemp?.toInt())
            Glide.with(this).load("https://openweathermap.org/img/w/${weather.icon}.png").into(im)

    }

    private fun onFailure(t: Throwable) {
        Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
    }


}
