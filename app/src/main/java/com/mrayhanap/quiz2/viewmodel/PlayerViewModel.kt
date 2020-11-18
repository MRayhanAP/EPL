package com.mrayhanap.quiz2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mrayhanap.quiz2.model.PlayerModel

class PlayerViewModel(private var listPlayer: ArrayList<PlayerModel>) : ViewModel() {
    private val _mutableListPlayer: MutableLiveData<List<PlayerModel>> = MutableLiveData(listPlayer)
    val listPlayerLiveData: LiveData<List<PlayerModel>>
        get() = _mutableListPlayer
}