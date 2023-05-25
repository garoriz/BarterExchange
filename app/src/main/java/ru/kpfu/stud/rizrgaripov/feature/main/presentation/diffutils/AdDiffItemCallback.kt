package ru.kpfu.stud.rizrgaripov.feature.main.presentation.diffutils

import androidx.recyclerview.widget.DiffUtil
import ru.kpfu.stud.rizrgaripov.storage.Ad

class AdDiffItemCallback : DiffUtil.ItemCallback<Ad>() {
    override fun areItemsTheSame(
        oldItem: Ad,
        newItem: Ad
    ): Boolean = oldItem.name == newItem.name

    override fun areContentsTheSame(
        oldItem: Ad,
        newItem: Ad
    ): Boolean = oldItem == newItem
}
