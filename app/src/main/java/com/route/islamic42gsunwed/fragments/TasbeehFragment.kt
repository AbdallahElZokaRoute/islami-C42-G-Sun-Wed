package com.route.islamic42gsunwed.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamic42gsunwed.databinding.FragmentTasbeehBinding

class TasbeehFragment : Fragment() {
    private lateinit var binding: FragmentTasbeehBinding
    private val adhkarList = listOf("سبحان الله", "الحمد الله", "الله أكبر")
    private var adhkarIndex = 0
    private var count = 33

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasbeehBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateUi()

        binding.sebhaBody.setOnClickListener {
            count--
            if (count == 0) {
                count = 33
                adhkarIndex = (adhkarIndex + 1) % adhkarList.size
            }
            updateUi()

            binding.sebhaBody.animate().apply {
                duration = 300
                rotationBy(15f)
            }
        }
    }

    private fun updateUi() {
        binding.adhkarText.text = adhkarList[adhkarIndex]
        binding.adhkarCount.text = count.toString()
    }
}
