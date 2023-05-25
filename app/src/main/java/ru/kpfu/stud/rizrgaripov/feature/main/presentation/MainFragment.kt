package ru.kpfu.stud.rizrgaripov.feature.main.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.stud.rizrgaripov.R
import ru.kpfu.stud.rizrgaripov.databinding.FragmentMainBinding
import ru.kpfu.stud.rizrgaripov.feature.profile.presentation.ProfileViewModel
import ru.kpfu.stud.rizrgaripov.feature.profile.presentation.adapter.AdListAdapter
import ru.kpfu.stud.rizrgaripov.storage.Storage

private const val ARG_NAME = "name"

class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var binding: FragmentMainBinding
    private val viewModel = MainViewModel()
    private var adListAdapter: AdListAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        initObservers()

        adListAdapter = AdListAdapter { clickedAd ->
            view.findNavController().navigate(
                R.id.action_mainFragment_to_adFragment,
                bundleOf(ARG_NAME to clickedAd))
        }

        val decorator = DividerItemDecoration(requireContext(), RecyclerView.VERTICAL)

        binding.ads.run {
            adapter = adListAdapter
            addItemDecoration(decorator)
        }

        with(binding) {
            if (Storage.currentUser != null)
                tvUser.text = Storage.currentUser!!.name

            svAd.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    viewModel.onGetAds(query)
                    return false
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    return false
                }
            })

            tvUser.setOnClickListener {
                if (Storage.currentUser == null)
                    view.findNavController().navigate(
                        R.id.action_mainFragment_to_signInFragment2,
                    )
                else
                    view.findNavController().navigate(
                        R.id.action_mainFragment_to_profileFragment,
                    )
            }
        }

        viewModel.onGetAds("")
    }

    private fun initObservers() {
        viewModel.response.observe(viewLifecycleOwner) { it ->
            it.fold(onSuccess = {
                adListAdapter?.submitList(it)
            }, onFailure = {
                Log.e("e", it.message.toString())
            })
        }
    }
}
