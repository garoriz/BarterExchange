package ru.kpfu.stud.rizrgaripov.feature.profile.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.stud.rizrgaripov.R
import ru.kpfu.stud.rizrgaripov.databinding.FragmentProfileBinding
import ru.kpfu.stud.rizrgaripov.feature.profile.presentation.adapter.AdListAdapter
import ru.kpfu.stud.rizrgaripov.storage.Storage

private const val ARG_NAME = "name"

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private lateinit var binding: FragmentProfileBinding
    private val viewModel = ProfileViewModel()
    private var adListAdapter: AdListAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

        initObservers()

        with(binding) {
            tvCityVal.text = Storage.currentUser?.city ?: ""
            tvEmailVal.text = Storage.currentUser?.email ?: ""
            tvPhoneVal.text = Storage.currentUser?.phoneNum ?: ""
            btnExit.setOnClickListener {
                Storage.currentUser = null
                view.findNavController().popBackStack()
            }
            btnAddAd.setOnClickListener {
                view.findNavController().navigate(R.id.action_profileFragment_to_addAdFragment)
            }
        }

        viewModel.onGetAds(Storage.currentUser?.email ?: "")
    }

    private fun initObservers() {
        viewModel.response.observe(viewLifecycleOwner) { it ->
            it.fold(onSuccess = {
                adListAdapter = AdListAdapter { clickedAd ->
                    view?.findNavController()?.navigate(
                        R.id.action_profileFragment_to_adFragment,
                        bundleOf(ARG_NAME to clickedAd)
                    )
                }

                val decorator = DividerItemDecoration(requireContext(), RecyclerView.VERTICAL)

                binding.ads.run {
                    adapter = adListAdapter
                    addItemDecoration(decorator)
                }

                adListAdapter?.submitList(it)
            }, onFailure = {
                Log.e("e", it.message.toString())
            })
        }
    }
}
