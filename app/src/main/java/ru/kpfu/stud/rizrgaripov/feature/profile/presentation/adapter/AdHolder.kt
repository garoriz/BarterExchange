package ru.kpfu.stud.rizrgaripov.feature.profile.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.stud.rizrgaripov.databinding.ItemAdBinding
import ru.kpfu.stud.rizrgaripov.storage.Ad

class AdHolder(
    private val binding: ItemAdBinding,
    private val action: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    private var ad: Ad? = null

    init {
        itemView.setOnClickListener {
            ad?.name?.also(action)
        }
    }

    fun bind(item: Ad) {
        this.ad = item
        with(binding) {
            tvHeading.text = item.name
            tvText.text = item.desc
            ivPhoto.setImageURI(item.uri)
        }
    }

    companion object {

        fun create(
            parent: ViewGroup,
            action: (String) -> Unit
        ) = AdHolder(
            ItemAdBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), action
        )
    }
}
