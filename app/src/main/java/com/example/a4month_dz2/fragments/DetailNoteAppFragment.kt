package com.example.a4month_dz2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.a4month_dz2.R
import com.example.a4month_dz2.databinding.FragmentDetailNoteAppBinding

class DetailNoteAppFragment : Fragment() {

    private lateinit var binding: FragmentDetailNoteAppBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailNoteAppBinding.inflate(inflater , container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sendData()
    }

    private fun sendData()= with(binding) {
        btnDone.setOnClickListener{
            val title = edTitle.text.toString()
            val description = edDescription.text.toString()

            findNavController().navigate(
                NoteAppFragmentDirections.actionNoteAppFragmentToDetailNoteAppFragment(     ))
        }
    }
}