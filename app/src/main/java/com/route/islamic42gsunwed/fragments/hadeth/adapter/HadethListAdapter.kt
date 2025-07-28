package com.route.islamic42gsunwed.fragments.hadeth.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic42gsunwed.databinding.ItemHadethBinding
import com.route.islamic42gsunwed.fragments.hadeth.model.HadethDM

class HadethListAdapter(private val hadethList: List<HadethDM>) :
    RecyclerView.Adapter<HadethListAdapter.HadethViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HadethViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ItemHadethBinding.inflate(inflater, parent, false)
        return HadethViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: HadethViewHolder,
        position: Int
    ) {
        holder.bind(item = hadethList.get(position))
    }

    override fun getItemCount(): Int {
        return hadethList.size
    }

    class HadethViewHolder(val binding: ItemHadethBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HadethDM) {
            binding.hadethTitle.text = item.title
            binding.hadethDesc.text = item.description
        }
    }
}
