package ru.kpfu.stud.rizrgaripov.feature.main.domain.usecase

import ru.kpfu.stud.rizrgaripov.feature.main.data.GetAdsRepoImpl
import ru.kpfu.stud.rizrgaripov.storage.Ad

class GetAdsUseCase {
    private val getAdsRepo = GetAdsRepoImpl()

    operator fun invoke(name: String): MutableList<Ad> {
        return getAdsRepo.getAds(name)
    }
}
