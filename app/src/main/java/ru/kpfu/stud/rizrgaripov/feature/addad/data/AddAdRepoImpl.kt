package ru.kpfu.stud.rizrgaripov.feature.addad.data

import ru.kpfu.stud.rizrgaripov.feature.addad.domain.repo.AddAdRepo
import ru.kpfu.stud.rizrgaripov.storage.Ad
import ru.kpfu.stud.rizrgaripov.storage.Storage

class AddAdRepoImpl : AddAdRepo {
    override fun addAd(ad: Ad) {
        Storage.addAd(ad)
    }
}
