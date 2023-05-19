package ru.kpfu.stud.rizrgaripov.feature.signup.domain.usecase

import ru.kpfu.stud.rizrgaripov.feature.signup.data.AddUserRepoImpl
import ru.kpfu.stud.rizrgaripov.storage.User

class AddUserUseCase {
    private val addUserRepo = AddUserRepoImpl()

    operator fun invoke(user: User) {
        return addUserRepo.addUser(user)
    }
}
