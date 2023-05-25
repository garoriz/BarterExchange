package ru.kpfu.stud.rizrgaripov.feature.main.domain.repo

import ru.kpfu.stud.rizrgaripov.storage.Ad

interface GetAdsRepo {
    fun getAds(name: String): MutableList<Ad>
}
