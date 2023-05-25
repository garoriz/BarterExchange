package ru.kpfu.stud.rizrgaripov.feature.main.data

import ru.kpfu.stud.rizrgaripov.feature.main.domain.repo.GetAdsRepo
import ru.kpfu.stud.rizrgaripov.storage.Ad
import ru.kpfu.stud.rizrgaripov.storage.Storage

class GetAdsRepoImpl : GetAdsRepo {
    override fun getAds(name: String): MutableList<Ad> {
        var ads = Storage.getAdsByName(name)
        if (ads.isNotEmpty())
            ads = ads.reversed()
        return ads as MutableList<Ad>
    }
}
