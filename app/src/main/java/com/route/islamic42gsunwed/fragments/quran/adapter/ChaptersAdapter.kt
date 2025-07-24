package com.route.islamic42gsunwed.fragments.quran.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic42gsunwed.databinding.ItemQuranChapterBinding
import com.route.islamic42gsunwed.fragments.quran.callback.OnChapterClickListener
import com.route.islamic42gsunwed.fragments.quran.model.ChapterDM

class ChaptersAdapter(private val chapters: List<ChapterDM>) :
    RecyclerView.Adapter<ChaptersAdapter.ChapterViewHolder>() {
    //2-
    var onChapterClickListener: OnChapterClickListener? = null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChapterViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ItemQuranChapterBinding.inflate(inflater, parent, false)
        return ChapterViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ChapterViewHolder,
        position: Int
    ) {
        val item = chapters.get(position)
        holder.bind(item, position, onChapterClickListener)
    }

    override fun getItemCount(): Int {
        return chapters.size
    }


    class ChapterViewHolder(val binding: ItemQuranChapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ChapterDM, position: Int, onChapterClickListener: OnChapterClickListener?) {
            binding.chapterIndexTextView.text = "${item.index}"
            binding.chaptersLengthTextView.text = "${item.length} Verses"
            binding.chapterNameInEnglish.text = item.nameInEnglish
            binding.chapterNameInArabic.text = item.nameInArabic
            binding.root.setOnClickListener {
                // 3-
                onChapterClickListener?.onChapterClick(item, position)
            }
        }
    }
}
