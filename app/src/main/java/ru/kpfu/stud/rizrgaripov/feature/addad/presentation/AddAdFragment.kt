package ru.kpfu.stud.rizrgaripov.feature.addad.presentation

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.findNavController
import ru.kpfu.stud.rizrgaripov.R
import ru.kpfu.stud.rizrgaripov.databinding.FragmentAddAdBinding
import ru.kpfu.stud.rizrgaripov.databinding.FragmentProfileBinding
import ru.kpfu.stud.rizrgaripov.feature.profile.presentation.ProfileViewModel
import ru.kpfu.stud.rizrgaripov.feature.profile.presentation.adapter.AdListAdapter
import ru.kpfu.stud.rizrgaripov.storage.Ad
import ru.kpfu.stud.rizrgaripov.storage.Storage

class AddAdFragment : Fragment(R.layout.fragment_add_ad) {
    private lateinit var binding: FragmentAddAdBinding
    private val viewModel = AddAdViewModel()
    private val selectImageFromGalleryResult =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uriReponse: Uri? ->
            uriReponse?.let {
                uri = uriReponse
                binding.tvAddedPhoto.visibility = View.VISIBLE
            }
        }
    private var uri: Uri? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddAdBinding.bind(view)

        initObservers()

        with(binding) {
            tvAddPhoto.setOnClickListener {
                selectImageFromGallery()
            }

            tvPublish.setOnClickListener {
                viewModel.onAddAd(
                    Ad(
                        Storage.currentUser?.email ?: "",
                        tilName.editText?.text.toString().trim(),
                        tilDesc.editText?.text.toString().trim(),
                        uri
                    )
                )
            }
        }
    }

    private fun initObservers() {
        viewModel.response.observe(viewLifecycleOwner) { it ->
            it.fold(onSuccess = {
                view?.findNavController()?.popBackStack()
            }, onFailure = {
                Log.e("e", it.message.toString())
            })
        }
    }

    private fun selectImageFromGallery() = selectImageFromGalleryResult.launch("image/*")
}
