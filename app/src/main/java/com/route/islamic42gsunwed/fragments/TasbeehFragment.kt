package com.route.islamic42gsunwed.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamic42gsunwed.databinding.FragmentQuranBinding
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
val names:List<String> = listOf(
    "سبحان الله",
    "الحمد لله",
    "الله اكبر"
    )
    var displayedNameIndex: Int =0;
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tasbehName.text = "سبحان الله"
        binding.tasbehCounter.text = "0"
        binding.sebhaImg.viewTreeObserver.addOnGlobalLayoutListener {
            binding.sebhaImg.pivotX = binding.sebhaImg.width / 2f
            binding.sebhaImg.pivotY = binding.sebhaImg.height / 2f
        }
        binding.sebhaImg.setOnClickListener {
            var currentCounter = binding.tasbehCounter.text.toString().toInt()
            if(currentCounter == 32){
                binding.tasbehCounter.text = "0"
                binding.sebhaImg.rotation = 0f
                if(displayedNameIndex == 2){
                    displayedNameIndex = 0
                }else{
                    displayedNameIndex++

                }
                binding.tasbehName.text=names[displayedNameIndex]
                currentCounter=0

            }
            binding.tasbehCounter.text = "${currentCounter + 1}"
            binding.sebhaImg.rotation += 11f
        }

        super.onViewCreated(view, savedInstanceState)
    }

}
