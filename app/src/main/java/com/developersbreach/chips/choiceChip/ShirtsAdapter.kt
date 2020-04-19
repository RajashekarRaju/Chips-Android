package com.developersbreach.chips.choiceChip

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.chips.R

class ShirtsAdapter: ListAdapter<Shirts, ShirtsAdapter.ShirtsViewHolder>(DiffCallback) {


    class ShirtsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val shirtSizeTextView: TextView = itemView.findViewById(R.id.shirt_size_item_text_view)
        val shirtTypeTextView: TextView = itemView.findViewById(R.id.shirt_type_item_text_view)
        val shirtColorTextView: TextView = itemView.findViewById(R.id.shirt_color_item_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShirtsViewHolder {
        return ShirtsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_shirt,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ShirtsViewHolder, position: Int) {
        val shirts: Shirts = getItem(position)
        holder.shirtSizeTextView.text = shirts.size
        holder.shirtTypeTextView.text = shirts.type
        holder.shirtColorTextView.text = shirts.color
    }

    //override fun getItemCount() = shirtsList.size

    companion object DiffCallback : DiffUtil.ItemCallback<Shirts>() {
        override fun areItemsTheSame(oldItem: Shirts, newItem: Shirts): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Shirts, newItem: Shirts): Boolean {
            return oldItem == newItem
        }
    }

}