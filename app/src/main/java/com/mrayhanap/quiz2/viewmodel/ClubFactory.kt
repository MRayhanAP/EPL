package com.mrayhanap.quiz2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mrayhanap.quiz2.model.ClubModel

class ClubFactory(private var listClub: ArrayList<ClubModel>) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClubViewModel::class.java)) {
            return ClubViewModel(listClub = listClub) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}