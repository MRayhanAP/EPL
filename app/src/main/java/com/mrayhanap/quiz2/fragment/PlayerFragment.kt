package com.mrayhanap.quiz2.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrayhanap.quiz2.R
import com.mrayhanap.quiz2.databinding.FragmentPlayerBinding
import com.mrayhanap.quiz2.recycleview.PlayerRecycleView
import com.mrayhanap.quiz2.viewmodel.PlayerFactory
import com.mrayhanap.quiz2.viewmodel.PlayerViewModel

class PlayerFragment : Fragment() {
    private lateinit var binding: FragmentPlayerBinding
    private lateinit var viewModel: PlayerViewModel
    val args: PlayerFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val club = args.clubModel
        Log.e("Club", club.playerList.toString())
        viewModel = ViewModelProvider(
            this,
            PlayerFactory(listPlayer = club.playerList)
        ).get(PlayerViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_player, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRvPlayer()
    }

    private fun setupRvPlayer() {
        val recyclerView = binding.rvPlayer
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager
        val adapter = PlayerRecycleView()
        recyclerView.adapter = adapter
        viewModel.listPlayerLiveData.observe(viewLifecycleOwner, { value ->
            adapter.playerList = value
        })
    }
}