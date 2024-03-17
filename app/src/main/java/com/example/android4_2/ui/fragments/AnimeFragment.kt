package com.example.android4_2.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.insertFooterItem
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4_2.databinding.FragmentAnimeBinding
import com.example.android4_2.remote.models.Data
import com.example.android4_2.ui.adapters.AnimeAdapter
import com.example.android4_2.ui.models.AnimeData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : Fragment() {

    private val binding by viewBinding(FragmentAnimeBinding::bind)
    private val viewModel by viewModels<AnimeViewModel>()
    private val animeAdapter = AnimeAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserver()
    }

    private fun initialize() = with(binding) {
        rvAnime.apply {
            adapter = animeAdapter
        }
    }

    private fun setupObserver() {
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            viewLifecycleOwner.lifecycleScope.launch {
            }
            animeAdapter.submitData(it)
        }
    }
}