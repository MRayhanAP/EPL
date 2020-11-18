package com.mrayhanap.quiz2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mrayhanap.quiz2.model.PlayerModel

class PlayerFactory(private val listPlayer: ArrayList<PlayerModel>) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlayerViewModel::class.java)) {
            return PlayerViewModel(listPlayer = listPlayer) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}