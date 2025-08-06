package com.route.islamic42gsunwed.fragments.quran.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic42gsunwed.databinding.ItemQuranChapterBinding
import com.route.islamic42gsunwed.fragments.quran.callback.OnChapterClickListener
import com.route.islamic42gsunwed.fragments.quran.model.ChapterDM

class ChaptersAdapter2(
    private val chapters: List<ChapterDM>
) : RecyclerView.Adapter<ChaptersAdapter2.ChapterViewHolder2>() {
    // 2-
    var onChapterClickListener: OnChapterClickListener? = null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChapterViewHolder2 {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ItemQuranChapterBinding.inflate(inflater, parent, false)
        return ChapterViewHolder2(binding)
    }


    override fun onBindViewHolder(
        holder: ChapterViewHolder2,
        position: Int
    ) {
        val item = chapters.get(position)
        holder.bind(item, onChapterClickListener, position)

    }

    override fun getItemCount(): Int {
        return chapters.size
    }

    class ChapterViewHolder2(private val binding: ItemQuranChapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            chapter: ChapterDM,
            onChapterClickListener: OnChapterClickListener?,
            position: Int
        ) {
            binding.chapterIndexTextView.text = "${chapter.index}"
            binding.chaptersLengthTextView.text = "${chapter.length} Verses"
            binding.chapterNameInEnglish.text = chapter.nameInEnglish
            binding.chapterNameInArabic.text = chapter.nameInArabic
            binding.root.setOnClickListener {
                // 3 -
                onChapterClickListener?.onChapterClick(chapter, position)
            }
        }
    }
}
