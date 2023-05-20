package ru.kpfu.stud.rizrgaripov.feature.signup.presentation

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
import ru.kpfu.stud.rizrgaripov.databinding.FragmentSignUpBinding
import ru.kpfu.stud.rizrgaripov.storage.User
import java.util.regex.Pattern

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {
    private lateinit var binding: FragmentSignUpBinding
    private val viewModel = SignUpViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpBinding.bind(view)

        initObservers()

        with(binding) {
            btnSignUp.setOnClickListener {
                tvNotSamePassword.visibility = View.GONE
                tvWriteEmail.visibility = View.GONE
                tvWriteName.visibility = View.GONE
                tvWriteSurname.visibility = View.GONE
                tvInvalidPhoneNumber.visibility = View.GONE
                tvWriteFirstPassword.visibility = View.GONE
                tvWriteSecondPassword.visibility = View.GONE

                if (isRightData()) {
                    viewModel.onAddUser(
                        User(
                            tilName.editText?.text.toString().trim(),
                            tilSurname.editText?.text.toString().trim(),
                            tilEmail.editText?.text.toString().trim(),
                            tilPhoneNumber.editText?.text.toString().trim(),
                            tilPassword.editText?.text.toString().trim(),
                        )
                    )
                }
            }

            tvSignIn.setOnClickListener {
                view.findNavController().navigate(
                    R.id.action_signUpFragment_to_signInFragment,
                    null,
                    NavOptions.Builder().setPopUpTo(R.id.mainFragment, false).build())
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

    private fun isRightData(): Boolean {
        var isRight = true
        with(binding) {
            if (tilPassword.editText?.text.toString().isBlank()) {
                tvWriteFirstPassword.visibility = View.VISIBLE
                isRight = false
            }
            if (tilConfirmPassword.editText?.text.toString().isBlank()) {
                tvWriteSecondPassword.visibility = View.VISIBLE
                isRight = false
            }
            if (tilPassword.editText?.text.toString() !=
                tilConfirmPassword.editText?.text.toString()) {
                tvNotSamePassword.visibility = View.VISIBLE
                isRight = false
            }
            if (tilName.editText?.text.toString().isBlank()) {
                tvWriteName.visibility = View.VISIBLE
                isRight = false
            }
            if (tilSurname.editText?.text.toString().isBlank()) {
                tvWriteSurname.visibility = View.VISIBLE
                isRight = false
            }
            if (tilEmail.editText?.text.toString().isBlank()) {
                tvWriteEmail.visibility = View.VISIBLE
                isRight = false
            }
            if (!isRightPhoneNumber()) {
                tvInvalidPhoneNumber.visibility = View.VISIBLE
                isRight = false
            }
        }
        return isRight
    }

    private fun isRightPhoneNumber(): Boolean {
        with(binding) {
            val p1 = Pattern.compile("[+]7[0-9]{10}")
            val p2 = Pattern.compile("8[0-9]{10}")
            val m1 = p1.matcher(tilPhoneNumber.editText?.text.toString().trim())
            val m2 = p2.matcher(tilPhoneNumber.editText?.text.toString().trim())
            return m1.matches() or m2.matches()
        }
    }
}
