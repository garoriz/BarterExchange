package ru.kpfu.stud.rizrgaripov.feature.profile.data

import ru.kpfu.stud.rizrgaripov.feature.profile.domain.repo.GetAdsRepo
import ru.kpfu.stud.rizrgaripov.storage.Ad
import ru.kpfu.stud.rizrgaripov.storage.Storage

class GetAdsRepoImpl : GetAdsRepo {
    override fun getAds(email: String): MutableList<Ad> {
        return Storage.getAds(email) as MutableList<Ad>
    }
}
