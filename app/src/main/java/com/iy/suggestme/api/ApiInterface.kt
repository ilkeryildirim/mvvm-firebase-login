package com.iy.suggestme.api

import com.iy.suggestme.model.Photos
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {

    @GET("list")
    fun getPhotos(): Observable<List<Photos>>
}