package com.iy.suggestme.ui.photos


import android.view.View
import androidx.lifecycle.MutableLiveData
import com.iy.suggestme.model.Photos
import com.iy.suggestme.api.ApiInterface
import com.iy.suggestme.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import workOnBackground
import javax.inject.Inject

class MainActivityViewModel : BaseViewModel() {

    @Inject
    lateinit var apiInterface: ApiInterface

    var loadingVisibility = MutableLiveData<Int>()
    var errorMessage: MutableLiveData<String> = MutableLiveData()
    var photosAdapter: PhotosAdapter = PhotosAdapter()
    val errorClickListener = View.OnClickListener { }
    private lateinit var subscription: Disposable
    private var compositeDisposable = CompositeDisposable()

    init {
        getPhotos()
    }

    private fun getPhotos() {
        showLoading()
        val observable: Observable<List<Photos>> = apiInterface.getPhotos().workOnBackground()
        subscription = observable.subscribe({ list ->
            hideLoading()
            onPhotosRequestResponse(list)
        }, { error ->
            hideLoading()
            onPhotosRequestError(error.localizedMessage)
        })
        compositeDisposable.add(subscription)

    }


    private fun onPhotosRequestResponse(photosList: List<Photos>) {
        photosAdapter.updatePhotosList(photosList)

    }

    private fun onPhotosRequestError(message: String) {
        errorMessage.value=message
    }

    private fun showLoading() {
        loadingVisibility.value = View.VISIBLE
    }

    private fun hideLoading() {
        loadingVisibility.value = View.INVISIBLE
    }
}

