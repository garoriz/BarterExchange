package ru.kpfu.stud.rizrgaripov.feature.addad.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.kpfu.stud.rizrgaripov.feature.addad.domain.usecase.AddAdUseCase
import ru.kpfu.stud.rizrgaripov.storage.Ad

class AddAdViewModel : ViewModel() {
    private val addAdUseCase = AddAdUseCase()

    private var _response: MutableLiveData<Result<Unit>> = MutableLiveData()
    val response: LiveData<Result<Unit>> = _response

    fun onAddAd(ad: Ad) {
        val response = addAdUseCase.invoke(ad)
        _response.value = Result.success(response)
    }
}
