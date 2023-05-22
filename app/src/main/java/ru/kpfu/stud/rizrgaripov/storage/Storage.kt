package ru.kpfu.stud.rizrgaripov.storage

object Storage {
    var users: List<User> = listOf(User(
        "Ризван",
        "Гарипов",
        "rizvan_garipov@gmail.com",
        "89999556747",
        "qwerty"
    ))
        private set

    fun addUser(user: User) {
        users = users + listOf(user)
    }

    var currentUser: User? = null

    fun signIn(email: String, password: String): Boolean {
        for (user in users)
            if (email == user.email && password == user.password) {
                currentUser = user
                return true
            }
        return false
    }
}
