package com.example.a4month_dz2.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a4month_dz2.models.NoteModel
import com.example.a4month_dz2.databinding.ItemNoteappBinding

class NoteAppAdapter : RecyclerView.Adapter<NoteAppAdapter.NoteViewHolder>() {

    private var list: List<NoteModel> = ArrayList()

    fun setList(list: List<NoteModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    class NoteViewHolder(private val binding: ItemNoteappBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(noteModel: NoteModel) {
            binding.txtTitle.text = noteModel.title
            binding.txtDescription.text = noteModel.description
            binding.textData.text = noteModel.data
            binding.textTime.text = noteModel.time
            binding.cardView.setCardBackgroundColor(Color.parseColor(noteModel.color))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemNoteappBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}