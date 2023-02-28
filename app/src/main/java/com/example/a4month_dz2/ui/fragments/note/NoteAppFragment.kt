package com.example.a4month_dz2.ui.fragments.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a4month_dz2.App
import com.example.a4month_dz2.ui.adapters.NoteAppAdapter
import com.example.a4month_dz2.R
import com.example.a4month_dz2.databinding.FragmentNoteAppBinding
import com.example.a4month_dz2.utils.PreferenceHelper

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
        changeLayoutManager()
    }

    private fun changeLayoutManager() {
        if (PreferenceHelper.save) {
            binding.rvNoteApp.layoutManager = LinearLayoutManager(requireContext())
        } else {
            binding.rvNoteApp.layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    private fun initialize() {
        binding.rvNoteApp.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = noteAppAdapter
        }
    }

    private fun setupListener() = with(binding) {
        binding.btnPlus.setOnClickListener {
            findNavController().navigate(R.id.action_noteAppFragment_to_detailNoteAppFragment)
        }
        btnGrid.setOnClickListener {
            PreferenceHelper.save = false
            rvNoteApp.layoutManager = GridLayoutManager(requireContext(), 2)
            btnGrid.isVisible = false
            btnLiner.isVisible = true
        }
        btnLiner.setOnClickListener {
            PreferenceHelper.save = false
            rvNoteApp.layoutManager = LinearLayoutManager(requireContext())
            btnGrid.isVisible = true
            btnLiner.isVisible = false
        }
    }

    private fun setList() {
        App().getInstance()?.noteDao()?.getAll()?.observe(viewLifecycleOwner) { list ->
            noteAppAdapter.setList(list)
        }
    }

}
