package ru.kpfu.stud.rizrgaripov.feature.profile.domain.usecase

import ru.kpfu.stud.rizrgaripov.feature.profile.data.GetAdsRepoImpl
import ru.kpfu.stud.rizrgaripov.storage.Ad

class GetAdsUseCase {
    private val getAdsRepo = GetAdsRepoImpl()

    operator fun invoke(email: String): MutableList<Ad> {
        return getAdsRepo.getAds(email)
    }
}
