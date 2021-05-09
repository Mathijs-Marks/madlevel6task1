package com.example.madlevel6task1.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.madlevel6task1.R
import com.example.madlevel6task1.databinding.ItemColourBinding
import com.example.madlevel6task1.model.ColourItem

class ColourAdapter(private val colours: List<ColourItem>, private val onClick: (ColourItem) -> Unit) :
    RecyclerView.Adapter<ColourAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_colour, parent, false)
        )
    }

    override fun getItemCount(): Int = colours.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(colours[position])

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener { onClick(colours[adapterPosition]) }
        }

        private val binding = ItemColourBinding.bind(itemView)

        fun bind(colourItem: ColourItem) {
            Glide.with(context).load(colourItem.getImageUrl()).into(binding.ivColour)
        }
    }
}