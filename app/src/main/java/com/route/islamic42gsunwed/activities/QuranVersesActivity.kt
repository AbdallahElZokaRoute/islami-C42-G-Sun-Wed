package com.route.islamic42gsunwed.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.route.islamic42gsunwed.R
import com.route.islamic42gsunwed.fragments.quran.ChapterKeys

class QuranVersesActivity : AppCompatActivity() {
    var chapterNameEnglish: String? = null
    var chapterNameArabic: String? = null
    var chapterLength: String? = null
    var chapterIndex: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quran_verses)
        chapterNameEnglish = intent.getStringExtra(ChapterKeys.chapterNameEnglish)
        chapterNameArabic = intent.getStringExtra(ChapterKeys.chapterNameArabic)
        chapterIndex = intent.getIntExtra(ChapterKeys.chapterIndex, -1)
        chapterLength = intent.getStringExtra(ChapterKeys.chapterLength)
        /**
         *  //
         *   1- Fork Islami C42 G SUn Wed Repository  ( copy master branch only -> X  )
         *   2- Clone your forked Repository
         *   3- create new branch from `feature-quran` and name it ("feature-tasbeeh")
         *   4- Develop Tasbeeh Feature
         *   5- After finishing the task go commit and push to your forked repository
         *   6- Create Pull Request (from Github not android studio)
         *   7- from your forked repository (feature-tasbeeh) to My Repository (develop)
         *
         */

    }
}