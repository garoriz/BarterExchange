package ru.kpfu.stud.rizrgaripov.storage

object Storage {
    var users: List<User> = listOf(User(
        "Ризван",
        "Гарипов",
        "rizvan_garipov@gmail.com",
        "89999556747",
        "Казань",
        "qwerty"
    ))
        private set

    fun addUser(user: User) {
        users = users + listOf(user)
    }

    fun getUser(email: String): User? {
        for (user in users)
            if (user.email == email)
                return user
        return null
    }

    var ads: List<Ad> = mutableListOf(Ad(
        "rizvan_garipov@gmail.com",
        "Кроссовки",
        "Хорошие кроссовки",
        null
    ),
    Ad(
        "rizvan_garipov@gmail.com",
        "Пианино",
        "Готов поменять на гитару",
        null,
    ),
        Ad(
            "rizvan_garipov@gmail.com",
            "PS5",
            "Не нужен",
            null,
        ),)
        private set

    fun addAd(ad: Ad) {
        ads = ads + listOf(ad)
    }

    fun getAds(email: String): List<Ad> {
        val result = mutableListOf<Ad>()
        for (ad in ads) {
            if (ad.owner == email)
                result.add(ad)
        }
        return result
    }

    fun getAdsByName(name: String): List<Ad> {
        val result = mutableListOf<Ad>()
        for (ad in ads) {
            if (ad.name.contains(name))
                result.add(ad)
        }
        return result
    }

    var currentUser: User? = null

    fun getAd(name: String): Ad? {
        for (ad in ads) {
            if (ad.name == name)
                return ad
        }
        return null
    }

    fun deleteAd(name: String) {
        val result = mutableListOf<Ad>()
        for (ad in ads) {
            if (ad.name != name)
                result.add(ad)
        }
        ads = result
    }

    fun signIn(email: String, password: String): Boolean {
        for (user in users)
            if (email == user.email && password == user.password) {
                currentUser = user
                return true
            }
        return false
    }
}
