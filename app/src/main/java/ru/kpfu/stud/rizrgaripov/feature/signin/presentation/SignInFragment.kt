package ru.kpfu.stud.rizrgaripov.feature.signin.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import ru.kpfu.stud.rizrgaripov.R
import ru.kpfu.stud.rizrgaripov.databinding.FragmentMainBinding
import ru.kpfu.stud.rizrgaripov.databinding.FragmentSignInBinding
import ru.kpfu.stud.rizrgaripov.storage.Storage

class SignInFragment : Fragment(R.layout.fragment_sign_in) {
    private lateinit var binding: FragmentSignInBinding
    private val viewModel = SignInViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignInBinding.bind(view)

        initObservers()

        with(binding) {
            btnSignIn.setOnClickListener {
                viewModel.onSignIn(
                    tilEmail.editText?.text.toString(),
                    tilPassword.editText?.text.toString()
                )
            }

            tvSignUp.setOnClickListener {
                view.findNavController().navigate(
                    R.id.action_signInFragment_to_signUpFragment,
                    null,
                    NavOptions.Builder().setPopUpTo(R.id.mainFragment, false).build()
                )
            }
        }
    }

    private fun initObservers() {
        viewModel.response.observe(viewLifecycleOwner) { it ->
            it.fold(onSuccess = {
                if (it)
                    view?.findNavController()?.popBackStack()
                else
                    Snackbar.make(
                        binding.root,
                        getString(R.string.no_user),
                        Snackbar.LENGTH_LONG
                    ).show()
            }, onFailure = {
                Log.e("e", it.message.toString())
            })
        }
    }
}
