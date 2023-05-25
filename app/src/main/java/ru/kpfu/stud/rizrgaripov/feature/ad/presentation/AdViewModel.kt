package ru.kpfu.stud.rizrgaripov.feature.ad.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.kpfu.stud.rizrgaripov.feature.ad.domain.usecase.DeleteAdUseCase
import ru.kpfu.stud.rizrgaripov.feature.ad.domain.usecase.GetAdUseCase
import ru.kpfu.stud.rizrgaripov.feature.ad.domain.usecase.GetUserUseCase
import ru.kpfu.stud.rizrgaripov.storage.Ad
import ru.kpfu.stud.rizrgaripov.storage.User

class AdViewModel : ViewModel() {
    private val getAdUseCase = GetAdUseCase()
    private val getUserUseCase = GetUserUseCase()
    private val deleteAdUseCase = DeleteAdUseCase()

    private var _responseAd: MutableLiveData<Result<Ad?>> = MutableLiveData()
    val responseAd: LiveData<Result<Ad?>> = _responseAd

    private var _responseUser: MutableLiveData<Result<User?>> = MutableLiveData()
    val responseUser: LiveData<Result<User?>> = _responseUser

    private var _responseDeleteAd: MutableLiveData<Result<Unit>> = MutableLiveData()
    val responseDeleteAd: LiveData<Result<Unit>> = _responseDeleteAd

    fun onGetAd(name: String) {
        val response = getAdUseCase.invoke(name)
        _responseAd.value = Result.success(response)
    }

    fun onGetUser(email: String) {
        val response = getUserUseCase.invoke(email)
        _responseUser.value = Result.success(response)
    }

    fun onDeleteAd(name: String) {
        val response = deleteAdUseCase.invoke(name)
        _responseDeleteAd.value = Result.success(response)
    }
}
