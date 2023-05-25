package ru.kpfu.stud.rizrgaripov.feature.ad.domain.usecase

import ru.kpfu.stud.rizrgaripov.feature.ad.data.DeleteAdRepoImpl

class DeleteAdUseCase {
    private val deleteAdRepo = DeleteAdRepoImpl()

    operator fun invoke(name: String) {
        return deleteAdRepo.deleteAd(name)
    }
}
