package ru.kpfu.stud.rizrgaripov.feature.ad.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import ru.kpfu.stud.rizrgaripov.R
import ru.kpfu.stud.rizrgaripov.databinding.FragmentAdBinding
import ru.kpfu.stud.rizrgaripov.storage.Storage

private const val ARG_NAME = "name"

class AdFragment : Fragment(R.layout.fragment_ad) {
    private lateinit var binding: FragmentAdBinding
    private val viewModel = AdViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAdBinding.bind(view)

        initObservers()

        arguments?.getString(ARG_NAME)?.let { viewModel.onGetAd(it) }
    }

    private fun initObservers() {
        viewModel.responseAd.observe(viewLifecycleOwner) { it ->
            it.fold(onSuccess = { ad ->
                with(binding) {
                    if (ad != null) {
                        tvHeader.text = ad.name

                        if (Storage.currentUser?.email == ad.owner)
                            ibDel.visibility = View.VISIBLE

                        tvContent.text = ad.desc
                        ivAd.setImageURI(ad.uri)
                        tvEmailVal.text = ad.owner
                        viewModel.onGetUser(ad.owner)

                        ibDel.setOnClickListener {
                            viewModel.onDeleteAd(ad.name)
                            view?.findNavController()?.popBackStack()
                        }
                    }
                }
            }, onFailure = {
                Log.e("e", it.message.toString())
            })
        }

        viewModel.responseUser.observe(viewLifecycleOwner) { it ->
            it.fold(onSuccess = {
                with(binding) {
                    if (it != null) {
                        tvCityVal.text = it.city
                        val nameSurname = "${it.name} ${it.surname}"
                        tvNameSurname.text = nameSurname
                        tvPhoneVal.text = it.phoneNum
                    }
                }
            }, onFailure = {
                Log.e("e", it.message.toString())
            })
        }
    }
}
