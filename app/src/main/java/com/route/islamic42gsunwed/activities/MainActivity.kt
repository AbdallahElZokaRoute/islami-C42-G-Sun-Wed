package com.route.islamic42gsunwed.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.route.islamic42gsunwed.R
import com.route.islamic42gsunwed.databinding.ActivityMainBinding
import com.route.islamic42gsunwed.fragments.hadeth.HadethFragment
import com.route.islamic42gsunwed.fragments.quran.QuranFragment
import com.route.islamic42gsunwed.fragments.RadioFragment
import com.route.islamic42gsunwed.fragments.TasbeehFragment

class MainActivity : AppCompatActivity() {
    // 0- Create new Project ( Islami )
    // 1- Git and Github (Version Control System) (VCS)
    // 2- Islami
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    fun initViews() {
        binding.islamicBottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_quran -> pushFragment(QuranFragment())
                R.id.navigation_hadeth -> pushFragment(HadethFragment())
                R.id.navigation_tasbeeh -> pushFragment(TasbeehFragment())
                R.id.navigation_radio -> pushFragment(RadioFragment())
            }
            return@setOnItemSelectedListener true
        }
        binding.islamicBottomNavView.selectedItemId = R.id.navigation_quran
    }

    fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(
            R.id.islamic_fragment_container,
            fragment
        ).commit()

    }
}
