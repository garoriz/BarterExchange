package ru.kpfu.stud.rizrgaripov.feature.ad.domain.repo

import ru.kpfu.stud.rizrgaripov.storage.Ad

interface GetAdRepo {
    fun getAd(name: String): Ad?
}
