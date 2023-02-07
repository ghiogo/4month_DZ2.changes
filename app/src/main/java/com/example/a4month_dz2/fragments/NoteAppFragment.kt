package com.example.a4month_dz2.fragments

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a4month_dz2.NoteAppAdapter
import com.example.a4month_dz2.R
import com.example.a4month_dz2.databinding.FragmentNoteAppBinding

class NoteAppFragment : Fragment() {

    private lateinit var binding: FragmentNoteAppBinding
    private val noteAppAdapter = NoteAppAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteAppBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setList()
        setupListener()
    }

    private fun initialize() {
        binding.rvNoteApp.apply {
            layoutManager =LinearLayoutManager(requireContext())
            adapter = noteAppAdapter
        }
    }

    private fun setupListener() {
        binding.btnPlus.setOnClickListener{
            findNavController().navigate(R.id.action_noteAppFragment_to_detailNoteAppFragment)
    }
    private fun setList() {

        }
    }
}
