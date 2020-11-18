package com.mrayhanap.quiz2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mrayhanap.quiz2.model.ClubModel

class ClubViewModel(private var listClub: ArrayList<ClubModel>) : ViewModel() {
    private val listClubMutableLiveData: MutableLiveData<List<ClubModel>> = MutableLiveData(listClub)
    private val _navigateToDetail = MutableLiveData<ClubModel?>()
    val listClubLiveData: LiveData<List<ClubModel>>
        get() = listClubMutableLiveData
    val navigateToDetailLiveData: LiveData<ClubModel?>
        get() = _navigateToDetail

    fun onClubClicked(clubModel: ClubModel) {
        _navigateToDetail.value = clubModel
    }

    fun onMovieDetailNavigated() {
        _navigateToDetail.value = null
    }
}