package ru.kpfu.stud.rizrgaripov.feature.ad.data

import ru.kpfu.stud.rizrgaripov.feature.ad.domain.repo.GetUserRepo
import ru.kpfu.stud.rizrgaripov.storage.Storage
import ru.kpfu.stud.rizrgaripov.storage.User

class GetUserRepoImpl : GetUserRepo {
    override fun getUser(email: String): User? {
        return Storage.getUser(email)
    }
}
