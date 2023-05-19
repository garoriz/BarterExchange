package ru.kpfu.stud.rizrgaripov.feature.main.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import ru.kpfu.stud.rizrgaripov.R
import ru.kpfu.stud.rizrgaripov.databinding.FragmentMainBinding
import ru.kpfu.stud.rizrgaripov.storage.Storage

class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        //initObservers()

        with(binding) {
            if (Storage.currentUser != null)
                tvUser.text = Storage.currentUser!!.name

            tvUser.setOnClickListener {
                view.findNavController().navigate(
                    R.id.action_mainFragment_to_signUpFragment
                )
            }
        }
    }
}
