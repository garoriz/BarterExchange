package ru.kpfu.stud.rizrgaripov.feature.ad.domain.usecase

import ru.kpfu.stud.rizrgaripov.feature.ad.data.GetAdRepoImpl
import ru.kpfu.stud.rizrgaripov.storage.Ad

class GetAdUseCase {
    private val getAdRepo = GetAdRepoImpl()

    operator fun invoke(name: String): Ad? {
        return getAdRepo.getAd(name)
    }
}
