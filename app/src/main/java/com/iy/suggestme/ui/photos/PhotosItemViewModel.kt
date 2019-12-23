package com.iy.suggestme.ui.photos

import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.iy.suggestme.base.BaseViewModel
import com.iy.suggestme.databinding.ItemPhotosRowBinding
import com.iy.suggestme.model.Photos


class PhotosItemViewModel : BaseViewModel() {

    private val author = MutableLiveData<String>()
    private val downloadUrl = MutableLiveData<String>()

    fun bind(photos: Photos, binding: ItemPhotosRowBinding) {

        author.value = photos.author
        downloadUrl.value = photos.download_url
        loadImage(binding.ivPhoto,downloadUrl.value)

    }

    fun loadImage(view: ImageView, url: String?) {
        Glide.with(view.context).load(url).into(view)

    }

    fun getPhotoAuthor() = author

    fun getPhotoUrl() = downloadUrl
}