package com.example.a4month_dz2.ui.fragments.note.detail

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.a4month_dz2.App
import com.example.a4month_dz2.databinding.FragmentDetailNoteAppBinding
import com.example.a4month_dz2.models.NoteModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DetailNoteAppFragment : Fragment() {

    private lateinit var binding: FragmentDetailNoteAppBinding
    private var backgroundColor = "#1E1E1E"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailNoteAppBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sendData()
        setupListener()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun sendData() = with(binding) {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd MMMM")
        val formatted = current.format(formatter)
        binding.edData.text = formatted

        btnDone.setOnClickListener {
            if (edTitle.text.isNotEmpty() && edDescription.text.isNotEmpty()) {
                val title = edTitle.text.toString()
                val description = edDescription.text.toString()
                val data = tvNumber.text.toString()
                App().getInstance()?.noteDao()?.insert(
                    NoteModel(
                        title,
                        description,
                        formatted,
                        data,
                        color = backgroundColor
                    )
                )

                findNavController().navigateUp()
            }
        }
    }

    private fun setupListener() = with(binding) {
        mtrBtn1.setOnClickListener {
            backgroundColor = "#1E1E1E"
            imgDots1.isVisible = true
            imgDots2.isVisible = false
            imgDots3.isVisible = false
        }
        mtrBtn2.setOnClickListener {
            backgroundColor = "#EBE4C9"
            imgDots1.isVisible = false
            imgDots2.isVisible = true
            imgDots3.isVisible = false
        }
        mtrBtn3.setOnClickListener {
            backgroundColor = "#571818"
            imgDots1.isVisible = false
            imgDots2.isVisible = false
            imgDots3.isVisible = true
        }
    }
}