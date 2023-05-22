package ru.kpfu.stud.rizrgaripov.feature.signin.domain.repo

interface SignInRepo {
    fun signIn(email: String, password: String): Boolean
}
