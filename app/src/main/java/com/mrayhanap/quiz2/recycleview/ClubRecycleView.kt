package com.mrayhanap.quiz2.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrayhanap.quiz2.databinding.ClubpicBinding
import com.mrayhanap.quiz2.model.ClubModel

class ClubRecycleView() :
    RecyclerView.Adapter<ClubRecycleView.ClubViewHolder>() {
    private lateinit var itemClubListener: ClubListener
    var clubList: List<ClubModel>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    constructor(itemClubListener: ClubListener) : this() {
        this.itemClubListener = itemClubListener
    }

    class ClubViewHolder(private val binding: ClubpicBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(club: ClubModel?, itemClubListener: ClubListener) {
            binding.club = club
            binding.clickListener = itemClubListener
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemClubBinding = ClubpicBinding.inflate(layoutInflater, parent, false)
        return ClubViewHolder(itemClubBinding)
    }

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.bind(clubList?.get(position), itemClubListener)
    }

    override fun getItemCount(): Int {
        return clubList?.size ?: 0
    }
}