package com.example.a4month_dz2.fragments.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a4month_dz2.R
import com.example.a4month_dz2.databinding.FragmentOnBoardPagingBinding


class OnBoardPagingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardPagingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardPagingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding) {
        when (requireArguments().getInt(ARG_ONBOARD_PAGE_POSITION)) {
            0 -> {
                tvText.text = "Очень удобный функционал"
                lottie.setAnimation(R.raw.lottie1)
            }
            1 -> {
                tvText.text = "Быстрый, качественный продукт"
                lottie.setAnimation(R.raw.lottie2)
            }
            2 -> {
                tvText.text = "Куча функций и интересных фишек"
                lottie.setAnimation(R.raw.lottie3)
            }
        }
    }

    companion object {
        const val ARG_ONBOARD_PAGE_POSITION = "onBoardPage"
    }
}