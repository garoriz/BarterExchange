package ru.kpfu.stud.rizrgaripov.feature.addad.domain.repo

import ru.kpfu.stud.rizrgaripov.storage.Ad

interface AddAdRepo {
    fun addAd(ad: Ad)
}
