package com.example.mymover.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mymover.Models.UserData
import com.example.mymover.databinding.ItemBinding
import com.squareup.picasso.Picasso

class UserAdapter(
    val list: List<UserData>,
    val onItemClick: (userdata: UserData) -> Unit
) : RecyclerView.Adapter<UserAdapter.VH>() {

    inner class VH(val itemBinding: ItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(data: UserData) {
            itemBinding.apply {
                tvName.text = data.name
                tvCreatedby.text = data.createdby
                tvFirstappearance.text = data.firstappearance
                tvPublisher.text = data.publisher
                tvTeam.text = data.team
                tvRealName.text = data.realname

                Picasso.get().load(data.imageurl).into(ItemImage)

                btnCard.setOnClickListener {
                    onItemClick.invoke(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        return holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}