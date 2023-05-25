package ru.kpfu.stud.rizrgaripov.feature.ad.domain.repo

import ru.kpfu.stud.rizrgaripov.storage.User

interface GetUserRepo {
    fun getUser(email: String): User?
}
