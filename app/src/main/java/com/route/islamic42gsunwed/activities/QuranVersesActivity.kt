package com.route.islamic42gsunwed.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.route.islamic42gsunwed.R
import com.route.islamic42gsunwed.activities.adapters.VersesAdapter
import com.route.islamic42gsunwed.databinding.ActivityQuranVersesBinding
import com.route.islamic42gsunwed.fragments.quran.ChapterKeys

class QuranVersesActivity : AppCompatActivity() {
    private var chapterNameEnglish: String? = null
    private var chapterNameArabic: String? = null
    private var chapterLength: String? = null
    private var chapterIndex: Int? = null
    private lateinit var adapter: VersesAdapter // null
    private lateinit var binding: ActivityQuranVersesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuranVersesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initArgs()
        initViews()

    }

    fun initArgs() {
        chapterNameEnglish = intent.getStringExtra(ChapterKeys.chapterNameEnglish)
        chapterNameArabic = intent.getStringExtra(ChapterKeys.chapterNameArabic)
        chapterIndex = intent.getIntExtra(ChapterKeys.chapterIndex, -1)
        chapterLength = intent.getStringExtra(ChapterKeys.chapterLength)

    }

    fun initViews() {
        binding.chapterTitleArabic.text = chapterNameArabic
        binding.chapterTitleEnglish.text = chapterNameEnglish
        binding.backIcon.setOnClickListener {
            finish()
        }
        val list = readChapterContents()
        adapter = VersesAdapter(list)
        binding.versesRecyclerView.adapter = adapter
    }

    fun readChapterContents(): List<String> {
        return assets.open("quran/$chapterIndex.txt").bufferedReader().use {
            it.readLines().filter {
                it.isNotEmpty() && it.isNotBlank()
            }
        }
    }
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