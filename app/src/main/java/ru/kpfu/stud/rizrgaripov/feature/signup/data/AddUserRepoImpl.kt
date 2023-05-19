package ru.kpfu.stud.rizrgaripov.feature.signup.data

import ru.kpfu.stud.rizrgaripov.feature.signup.domain.repo.AddUserRepo
import ru.kpfu.stud.rizrgaripov.storage.Storage
import ru.kpfu.stud.rizrgaripov.storage.User

class AddUserRepoImpl : AddUserRepo {
    override fun addUser(user: User) {
        Storage.addUser(user)
        Storage.currentUser = user
    }
}
