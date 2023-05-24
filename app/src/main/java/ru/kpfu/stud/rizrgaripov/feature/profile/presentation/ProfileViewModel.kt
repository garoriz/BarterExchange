package ru.kpfu.stud.rizrgaripov.feature.profile.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.kpfu.stud.rizrgaripov.feature.profile.domain.usecase.GetAdsUseCase
import ru.kpfu.stud.rizrgaripov.storage.Ad

class ProfileViewModel : ViewModel() {
    private val getAdsUseCase = GetAdsUseCase()

    private var _response: MutableLiveData<Result<MutableList<Ad>>> = MutableLiveData()
    val response: LiveData<Result<MutableList<Ad>>> = _response

    fun onGetAds(email: String) {
        val response = getAdsUseCase.invoke(email)
        _response.value = Result.success(response)
    }

}
