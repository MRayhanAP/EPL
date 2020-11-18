package com.mrayhanap.quiz2.model

import android.os.Parcelable
import com.mrayhanap.quiz2.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ClubModel(
    var name: String = "",
    var imageLogo: Int = R.drawable.ic_launcher_background,
    var playerList: ArrayList<PlayerModel>
) : Parcelable