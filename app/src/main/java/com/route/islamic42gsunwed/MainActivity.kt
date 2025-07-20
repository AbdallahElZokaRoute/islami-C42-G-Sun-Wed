package com.route.islamic42gsunwed

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.route.islamic42gsunwed.databinding.ActivityMainBinding
import com.route.islamic42gsunwed.fragments.HadethFragment
import com.route.islamic42gsunwed.fragments.QuranFragment
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
    }

    fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(
            R.id.islamic_fragment_container,
            fragment
        ).commit()

    }
}
