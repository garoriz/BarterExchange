package ru.kpfu.stud.rizrgaripov.feature.signin.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.kpfu.stud.rizrgaripov.feature.signin.domain.usecase.SignInUseCase

class SignInViewModel {
    private val signInUseCase = SignInUseCase()

    private var _response: MutableLiveData<Result<Boolean>> = MutableLiveData()
    val response: LiveData<Result<Boolean>> = _response

    fun onSignIn(email: String, password: String) {
        val response = signInUseCase.invoke(email, password)
        _response.value = Result.success(response)
    }
}
