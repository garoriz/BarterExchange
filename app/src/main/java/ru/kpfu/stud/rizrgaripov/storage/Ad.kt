package ru.kpfu.stud.rizrgaripov.storage

import android.net.Uri

data class Ad(
    val owner: String,
    val name: String,
    val desc: String,
    val uri: Uri?,
)
