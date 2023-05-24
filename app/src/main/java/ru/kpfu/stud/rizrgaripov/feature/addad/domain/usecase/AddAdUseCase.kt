package ru.kpfu.stud.rizrgaripov.feature.addad.domain.usecase

import ru.kpfu.stud.rizrgaripov.feature.addad.data.AddAdRepoImpl
import ru.kpfu.stud.rizrgaripov.storage.Ad

class AddAdUseCase {
    private val addAdRepo = AddAdRepoImpl()

    operator fun invoke(ad: Ad) {
        addAdRepo.addAd(ad)
    }
}
