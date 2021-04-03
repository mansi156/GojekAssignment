package com.mansi.gojekassignment.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mansi.gojekassignment.data.models.Items
import com.mansi.gojekassignment.databinding.ItemLayoutBinding

class MainAdapter(
    private val users: ArrayList<Items>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(private val view: ItemLayoutBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(item: Items) {
            view.textViewUserName.text = item.title
            view.textViewUserEmail.text = item.tags[0]
            Glide.with(view.imageViewAvatar.context)
                .load(item.owner.profileImage)
                .into(view.imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : DataViewHolder{
        val binding = ItemLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }


    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

        holder.bind(users[position])
    }


    fun addData(list: List<Items>) {
        users.addAll(list)
    }

}


