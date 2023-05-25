package ru.kpfu.stud.rizrgaripov.feature.ad.data

import ru.kpfu.stud.rizrgaripov.feature.ad.domain.repo.GetAdRepo
import ru.kpfu.stud.rizrgaripov.storage.Ad
import ru.kpfu.stud.rizrgaripov.storage.Storage

class GetAdRepoImpl : GetAdRepo {
    override fun getAd(name: String): Ad? {
        return Storage.getAd(name)
    }
}
