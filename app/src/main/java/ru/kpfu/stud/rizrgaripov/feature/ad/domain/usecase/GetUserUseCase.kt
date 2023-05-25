package ru.kpfu.stud.rizrgaripov.feature.ad.domain.usecase

import ru.kpfu.stud.rizrgaripov.feature.ad.data.GetUserRepoImpl
import ru.kpfu.stud.rizrgaripov.storage.User

class GetUserUseCase {
    private val getUserRepo = GetUserRepoImpl()

    operator fun invoke(email: String): User? {
        return getUserRepo.getUser(email)
    }
}
