package com.route.islamic42gsunwed.fragments.tasabeeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamic42gsunwed.R
import com.route.islamic42gsunwed.databinding.FragmentTasbeehBinding

class TasbeehFragment : Fragment() {
    private lateinit var binding: FragmentTasbeehBinding
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

        // Initialize views and set click listeners here
        binding.azkarTimesTextView.text = "0"
        binding.azkarTextView.text = "سبحان الله"

        binding.imageViewSebha.setOnClickListener {
            handleSebhaClick()
        }
    }

    private fun handleSebhaClick() {
        val currentCount = binding.azkarTimesTextView.text.toString().toInt()
        val newCount = currentCount + 1
        binding.azkarTimesTextView.text = newCount.toString()

        binding.imageViewSebha.animate().apply {
            duration = 100
            rotationBy(11f)
        }

        if (newCount == 33) {
            binding.azkarTimesTextView.text = "0"

            when(binding.azkarTextView.text.toString()){
                "سبحان الله" -> binding.azkarTimesTextView.text = "الله أكبر"
                "الله أكبر" -> binding.azkarTimesTextView.text = "الحمد لله"
                "الجمد لله" -> {
                    binding.imageViewSebha.setImageResource(R.drawable.sebha)
                    binding.azkarTimesTextView.text = "سبحان الله"
                }
            }

        }
    }

}
