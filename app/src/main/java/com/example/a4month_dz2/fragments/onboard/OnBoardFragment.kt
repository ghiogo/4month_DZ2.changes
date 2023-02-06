package com.example.a4month_dz2.fragments.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.a4month_dz2.R
import com.example.a4month_dz2.adapters.OnBoardViewPagerAdapter
import com.example.a4month_dz2.databinding.FragmentOnBoardBinding
import com.example.a4month_dz2.utils.PreferenceHelper


class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        dots()
        openHome()
    }

    private fun openHome() {
        PreferenceHelper.save = true
    }

    private fun initialize() {
        binding.viewPager.adapter = OnBoardViewPagerAdapter(this@OnBoardFragment)
        PreferenceHelper.unit(requireContext())
    }

    private fun setupListener() = with(binding.viewPager) {
        binding.btnSkip.setOnClickListener {
            if (currentItem < 2) {
                setCurrentItem(currentItem + 1, true)
            }
        }

        binding.btnStart.setOnClickListener {
            val preferenceHelper = PreferenceHelper
            preferenceHelper.unit(requireContext())
            findNavController().navigate(R.id.action_onBoardFragment_to_homeFragment)
        }
        nextButton()
    }

    private fun dots() = with(binding) {
        dotsIndicator.attachTo(viewPager)
    }

    private fun nextButton() = with(binding) {
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        btnSkip.isVisible = true
                        btnStart.isVisible = false
                    }
                    1 -> {
                        btnSkip.isVisible = true
                        btnStart.isVisible = false
                    }
                    2 -> {
                        btnSkip.isVisible = false
                        btnStart.isVisible = true
                    }
                }
                super.onPageSelected(position)
            }
        })
    }
}