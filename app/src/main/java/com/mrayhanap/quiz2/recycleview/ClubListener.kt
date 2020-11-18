package com.mrayhanap.quiz2.recycleview

import com.mrayhanap.quiz2.model.ClubModel

interface ClubListener {
    fun onClubClicked(clubModel: ClubModel)
}