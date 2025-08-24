package com.route.islamic42gsunwed.activities.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic42gsunwed.databinding.ItemVerseBinding

class VersesAdapter(private val verses: List<String>) :
    RecyclerView.Adapter<VersesAdapter.VerseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VerseViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ItemVerseBinding.inflate(inflater, parent, false)
        return VerseViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: VerseViewHolder,
        position: Int
    ) {
        val item = verses.get(position)
        holder.bind(item, position)
    }

    override fun getItemCount(): Int {
        return verses.size
    }

    class VerseViewHolder(val binding: ItemVerseBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String, position: Int) {
            binding.verseTextView.text = "$item [${position + 1}]"
        }
    }
}
