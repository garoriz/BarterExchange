package ru.kpfu.stud.rizrgaripov.storage

object Storage {
    var users: List<User> = emptyList()
        private set

    fun addUser(user: User) {
        users = users + listOf(user)
    }

    var currentUser: User? = null
}
