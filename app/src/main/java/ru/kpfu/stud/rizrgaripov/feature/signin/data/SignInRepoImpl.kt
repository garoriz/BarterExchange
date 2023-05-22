package ru.kpfu.stud.rizrgaripov.feature.signin.data

import ru.kpfu.stud.rizrgaripov.feature.signin.domain.repo.SignInRepo
import ru.kpfu.stud.rizrgaripov.storage.Storage

class SignInRepoImpl : SignInRepo {
    override fun signIn(email: String, password: String): Boolean {
        return Storage.signIn(email, password)
    }
}
