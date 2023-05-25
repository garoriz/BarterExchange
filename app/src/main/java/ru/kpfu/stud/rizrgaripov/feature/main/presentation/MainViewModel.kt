package ru.kpfu.stud.rizrgaripov.feature.main.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.kpfu.stud.rizrgaripov.feature.main.domain.usecase.GetAdsUseCase
import ru.kpfu.stud.rizrgaripov.storage.Ad

class MainViewModel : ViewModel() {
    private val getAdsUseCase = GetAdsUseCase()

    private var _response: MutableLiveData<Result<MutableList<Ad>>> = MutableLiveData()
    val response: LiveData<Result<MutableList<Ad>>> = _response

    fun onGetAds(name: String) {
        val response = getAdsUseCase.invoke(name)
        _response.value = Result.success(response)
    }
}
