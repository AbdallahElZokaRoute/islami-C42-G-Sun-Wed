package com.route.islamic42gsunwed.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import androidx.fragment.app.Fragment
import com.route.islamic42gsunwed.databinding.FragmentQuranBinding
import com.route.islamic42gsunwed.databinding.FragmentTasbeehBinding

class TasbeehFragment : Fragment() {
    private var counter=0
    private var currentAngle=0f
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
        binding.sebhaImage.setOnClickListener{
            counter++
            binding.counterText.text=counter.toString()
            when{
                counter in 61..90 -> {
                    binding.sebhaTextView.text="الله أكبر"
                }
                counter in 31..60 -> {
                    binding.sebhaTextView.text="الحمد لله"
                }
                else-> {
                    binding.sebhaTextView.text="سبحان الله"
                }
            }
            if(counter>90)
            {
                counter=0;
            }
            currentAngle+=30f
            val rotate=RotateAnimation(
                currentAngle-30f,currentAngle,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
            )
            rotate.duration =500
            rotate.fillAfter=true
            binding.sebhaImage.startAnimation(rotate)
        }

    }

}