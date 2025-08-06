package com.route.islamic42gsunwed

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.route.islamic42gsunwed.R

class TasbehActivity : AppCompatActivity() {
    var count: Int = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tasbeh)

        var rotation = 0f
        val countText = findViewById<TextView>(R.id.counter)
        val tasbehImage = findViewById<ImageView>(R.id.sebha_body)
        tasbehImage.setOnClickListener {
            rotation += 20f
            tasbehImage.rotation = rotation
            updateAdkar()
            countText.text = count.toString()

        }
    }

    fun updateAdkar() {
        count++
        val adkarText = findViewById<TextView>(R.id.adkar)

        if (count <= 33) {
            adkarText.text = "الله أكبر"
        } else if (count <= 66) {
            adkarText.text = "الحمد لله"
        } else if (count <= 99) {
            adkarText.text = "لا إله إلا الله"

        } else {
            count = 0;
        }
    }

}

