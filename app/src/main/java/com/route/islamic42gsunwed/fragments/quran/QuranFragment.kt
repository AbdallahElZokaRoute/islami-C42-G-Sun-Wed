package com.route.islamic42gsunwed.fragments.quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.route.islamic42gsunwed.activities.QuranVersesActivity
import com.route.islamic42gsunwed.databinding.FragmentQuranBinding
import com.route.islamic42gsunwed.databinding.ItemQuranChapterBinding
import com.route.islamic42gsunwed.fragments.quran.adapter.ChaptersAdapter
import com.route.islamic42gsunwed.fragments.quran.adapter.ChaptersAdapter2
import com.route.islamic42gsunwed.fragments.quran.callback.OnChapterClickListener
import com.route.islamic42gsunwed.fragments.quran.model.ChapterDM
import com.route.islamic42gsunwed.fragments.quran.utils.QuranUtils

class QuranFragment : Fragment() {
    private lateinit var binding: FragmentQuranBinding
    private lateinit var adapter: ChaptersAdapter2
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuranBinding.inflate(inflater, container, false)
//        val view = binding.quranRecyclerView.get(0) // getItems -> setAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ChaptersAdapter2(QuranUtils.getChapters())
        adapter.onChapterClickListener = object : OnChapterClickListener {
            override fun onChapterClick(chapterDM: ChapterDM, position: Int) {
                val intent = Intent(context, QuranVersesActivity::class.java)
                intent.putExtra(ChapterKeys.chapterNameArabic, chapterDM.nameInArabic)
                intent.putExtra(ChapterKeys.chapterNameEnglish, chapterDM.nameInEnglish)
                intent.putExtra(ChapterKeys.chapterIndex, chapterDM.index)
                intent.putExtra(ChapterKeys.chapterLength, chapterDM.length)
                startActivity(intent)
            }
        }
        binding.quranRecyclerView.adapter = adapter
    }

}