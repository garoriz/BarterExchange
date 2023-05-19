package ru.kpfu.stud.rizrgaripov.feature.signup.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.kpfu.stud.rizrgaripov.feature.signup.domain.usecase.AddUserUseCase
import ru.kpfu.stud.rizrgaripov.storage.User

class SignUpViewModel : ViewModel() {
    private val addUserUseCase = AddUserUseCase()

    private var _response: MutableLiveData<Result<Unit>> = MutableLiveData()
    val response: LiveData<Result<Unit>> = _response

    fun onAddUser(user: User) {
        val response = addUserUseCase.invoke(user)
        _response.value = Result.success(response)
    }
}
