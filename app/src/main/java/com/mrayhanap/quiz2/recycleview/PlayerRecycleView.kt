package com.mrayhanap.quiz2.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrayhanap.quiz2.databinding.PlayerdetBinding
import com.mrayhanap.quiz2.model.PlayerModel

class PlayerRecycleView() :
    RecyclerView.Adapter<PlayerRecycleView.PlayerViewHolder>() {
    var playerList: List<PlayerModel>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class PlayerViewHolder(private val binding: PlayerdetBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(player: PlayerModel?) {
            binding.player = player
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemPlayerBinding = PlayerdetBinding.inflate(layoutInflater, parent, false)
        return PlayerViewHolder(itemPlayerBinding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(playerList?.get(position))
    }

    override fun getItemCount(): Int {
        return playerList?.size ?: 0
    }
}