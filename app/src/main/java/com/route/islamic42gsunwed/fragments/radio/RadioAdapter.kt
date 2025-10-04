package com.route.islamic42gsunwed.fragments.radio

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic42gsunwed.R
import com.route.islamic42gsunwed.databinding.ItemRadioBinding
import com.route.islamic42gsunwed.fragments.radio.api.RadiosItem


class RadioAdapter(
    private var radios: MutableList<RadiosItem>,
    private val onPlayClick: (RadiosItem, Int) -> Unit,
    private val onMuteClick: (RadiosItem, Int) -> Unit
) : RecyclerView.Adapter<RadioAdapter.RadioViewHolder>() {

    private var currentUrl: String? = null
    private var isPlaying: Boolean = false
    private var mutedRadios: Set<String> = emptySet()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRadioBinding.inflate(inflater, parent, false)
        return RadioViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RadioViewHolder, position: Int) {
        val item = radios[position]
        val isMuted = mutedRadios.contains(item.url)

        holder.binding.volumeIc.setImageResource(
            if (isMuted) R.drawable.volume_cross_ic else R.drawable.volume_high_ic
        )

        holder.bind(item, item.url == currentUrl, isPlaying, isMuted)

        holder.binding.playPauseIc.setOnClickListener {
            onPlayClick(item, position)
        }

        holder.binding.volumeIc.setOnClickListener {
            onMuteClick(item, position)
        }
    }

    override fun getItemCount(): Int {
        return radios.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewList(newList: List<RadiosItem>) {
        radios.clear()
        radios.addAll(newList)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAllMuteStates(mutedSet: Set<String>) {
        this.mutedRadios = mutedSet
        notifyDataSetChanged()
    }

    fun updatePlayState(url: String?, playing: Boolean) {
        val oldIndex = radios.indexOfFirst { it.url == currentUrl }
        currentUrl = url
        isPlaying = playing
        if (oldIndex != -1) notifyItemChanged(oldIndex)
        val newIndex = radios.indexOfFirst { it.url == url }
        if (newIndex != -1) notifyItemChanged(newIndex)
    }

    class RadioViewHolder(val binding: ItemRadioBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RadiosItem, isCurrent: Boolean, isPlaying: Boolean, isMuted: Boolean) {
            binding.nameOfAlQaria.text = item.name ?: "Unknown Radio"

            if (isCurrent && isPlaying) {
                binding.playPauseIc.setImageResource(R.drawable.pause_ic)
                binding.radioBg.setImageResource(R.drawable.item_radio_bg_on)
            } else {
                binding.playPauseIc.setImageResource(R.drawable.play_ic)
                binding.radioBg.setImageResource(R.drawable.item_radio_bg_off)
            }

            if (isMuted) {
                binding.volumeIc.setImageResource(R.drawable.volume_cross_ic)
            } else {
                binding.volumeIc.setImageResource(R.drawable.volume_high_ic)
            }
        }
    }
}
