package com.route.islamic42gsunwed.fragments.hadeth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.HeroCarouselStrategy
import com.route.islamic42gsunwed.R
import com.route.islamic42gsunwed.databinding.FragmentHadethBinding
import com.route.islamic42gsunwed.fragments.hadeth.adapter.CarouselItemDecoration
import com.route.islamic42gsunwed.fragments.hadeth.adapter.HadethListAdapter
import com.route.islamic42gsunwed.fragments.hadeth.model.HadethDM

class HadethFragment : Fragment() {
    private lateinit var binding: FragmentHadethBinding
    private lateinit var adapter: HadethListAdapter
    private lateinit var carouselLayoutManager: CarouselLayoutManager
    // Hadeth Fragment -> Carousel Layout Manager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHadethBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = HadethListAdapter(readAhadethFile())
        binding.ahadethRecyclerView.adapter = adapter
        carouselLayoutManager =
            CarouselLayoutManager(HeroCarouselStrategy(), CarouselLayoutManager.HORIZONTAL)
        carouselLayoutManager.carouselAlignment = CarouselLayoutManager.ALIGNMENT_CENTER
        val margin = resources.getDimensionPixelSize(R.dimen.hadeth_item_margin)
        val itemDecoration = CarouselItemDecoration(margin)
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.ahadethRecyclerView)
        binding.ahadethRecyclerView.addItemDecoration(itemDecoration)
        binding.ahadethRecyclerView.layoutManager = carouselLayoutManager
    }

    fun readAhadethFile(): List<HadethDM> {
        val content = requireActivity().assets.open("ahadeth.txt").bufferedReader().use {
            it.readText()
        }
        val list = content.trim().split("#")
        val hadethList = mutableListOf<HadethDM>()
        for (i in 0 until list.size) {
            val currentHadeth = list.get(i)
            val currentHadethList = currentHadeth.trim().split("\n")
            if (currentHadethList.isNotEmpty() && currentHadethList.size > 1) {
                val title = currentHadethList.get(0)
                val description =
                    currentHadethList.subList(1, currentHadethList.size).joinToString()
                hadethList.add(HadethDM(title, description))
            }
        }
        return hadethList
    }
}