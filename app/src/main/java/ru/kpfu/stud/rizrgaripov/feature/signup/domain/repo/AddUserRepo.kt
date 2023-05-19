package ru.kpfu.stud.rizrgaripov.feature.signup.domain.repo

import ru.kpfu.stud.rizrgaripov.storage.User

interface AddUserRepo {
    fun addUser(user: User)
}
