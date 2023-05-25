package ru.kpfu.stud.rizrgaripov.feature.ad.data

import ru.kpfu.stud.rizrgaripov.feature.ad.domain.repo.DeleteAdRepo
import ru.kpfu.stud.rizrgaripov.storage.Storage

class DeleteAdRepoImpl : DeleteAdRepo {
    override fun deleteAd(name: String) {
        Storage.deleteAd(name)
    }
}
