package ru.kpfu.stud.rizrgaripov.feature.profile.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.kpfu.stud.rizrgaripov.feature.profile.presentation.diffutis.AdDiffItemCallback
import ru.kpfu.stud.rizrgaripov.storage.Ad

class AdListAdapter(
    private val action: (String) -> Unit,
) : ListAdapter<Ad, AdHolder>(AdDiffItemCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdHolder = AdHolder.create(parent, action)

    override fun onBindViewHolder(holder: AdHolder, position: Int) =
        holder.bind(getItem(position))

    override fun submitList(list: MutableList<Ad>?) {
        super.submitList(if (list == null) null else ArrayList(list))
    }
}
