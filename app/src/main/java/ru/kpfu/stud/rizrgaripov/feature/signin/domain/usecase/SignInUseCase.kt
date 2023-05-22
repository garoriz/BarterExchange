package ru.kpfu.stud.rizrgaripov.feature.signin.domain.usecase

import ru.kpfu.stud.rizrgaripov.feature.signin.data.SignInRepoImpl

class SignInUseCase {
    private val  signInRepo = SignInRepoImpl()

    operator fun invoke(email: String, password: String): Boolean {
        return signInRepo.signIn(email, password)
    }
}
