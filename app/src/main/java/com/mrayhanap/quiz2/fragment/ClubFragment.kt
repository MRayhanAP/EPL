package com.mrayhanap.quiz2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.mrayhanap.quiz2.R
import com.mrayhanap.quiz2.databinding.FragmentClubBinding
import com.mrayhanap.quiz2.model.ClubModel
import com.mrayhanap.quiz2.model.PlayerModel
import com.mrayhanap.quiz2.recycleview.ClubListener
import com.mrayhanap.quiz2.recycleview.ClubRecycleView
import com.mrayhanap.quiz2.viewmodel.ClubFactory
import com.mrayhanap.quiz2.viewmodel.ClubViewModel

class ClubFragment : Fragment() {
    private lateinit var binding: FragmentClubBinding
    private lateinit var viewModel: ClubViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val clubList: ArrayList<ClubModel> = clubmodel()
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_club, container, false)
        viewModel = ViewModelProvider(this, ClubFactory(listClub = clubList)).get(
            ClubViewModel::class.java
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRvClub()
    }

    private fun clubmodel(): ArrayList<ClubModel> {
        val club: ArrayList<ClubModel> = arrayListOf()
        val clubArray: Array<String> = resources.getStringArray(R.array.club)
        val playerClubList: ArrayList<Array<String>> = arrayListOf(
            resources.getStringArray(R.array.fcbhPlayer),
            resources.getStringArray(R.array.wolvesPlayer),
            resources.getStringArray(R.array.celsiPlayer),
            resources.getStringArray(R.array.arsenalPlayer),
            resources.getStringArray(R.array.mancesterPlayer),
            resources.getStringArray(R.array.aremaPlayer),
        )
        val logoClubList = arrayListOf(
            R.drawable.fcbh,
            R.drawable.wolves,
            R.drawable.celsi,
            R.drawable.arsenal,
            R.drawable.mancester,
            R.drawable.arema
        )
        clubArray.forEachIndexed { index, name ->
            val playerList: ArrayList<PlayerModel> = arrayListOf()
            for (player in playerClubList[index]) {
                playerList.add(
                    PlayerModel(name = player)
                )
            }
            club.add(
                ClubModel(name = name, imageLogo = logoClubList[index], playerList = playerList)
            )
        }
        return club
    }

    private fun setupRvClub() {
        val recyclerView = binding.rvClub
        val gridLayoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = gridLayoutManager
        val adapter = ClubRecycleView(itemClubListener = object : ClubListener {
            override fun onClubClicked(clubModel: ClubModel) {
                viewModel.onClubClicked(clubModel)
            }
        })
        recyclerView.adapter = adapter
        viewModel.listClubLiveData.observe(
            viewLifecycleOwner,
            { value -> adapter.clubList = value })
        viewModel.navigateToDetailLiveData.observe(viewLifecycleOwner, { value ->
            if (value != null) {
                val action =
                    ClubFragmentDirections.actionClubFragmentToPlayerFragment(clubModel = value)
                findNavController().navigate(action)
                viewModel.onMovieDetailNavigated()
            }
        })
    }
}