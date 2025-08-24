package com.route.islamic42gsunwed.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.route.islamic42gsunwed.R

class SplashIslamiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_islami)
        Handler(Looper.getMainLooper()).postDelayed(object : Runnable {
            override fun run() {
                navigateToHomeActivity()
            }
        }, 2000)
    }

    fun navigateToHomeActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}