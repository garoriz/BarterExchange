package ru.kpfu.stud.rizrgaripov.feature.profile.domain.repo

import ru.kpfu.stud.rizrgaripov.storage.Ad

interface GetAdsRepo {
    fun getAds(email: String): MutableList<Ad>
}
