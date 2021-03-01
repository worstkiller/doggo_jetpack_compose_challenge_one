package com.vikas.doggoadoption.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class DoggoResponseModel(val id: String, val url: String)

@Parcelize
data class DoggoBreedResponseModel(
    val breed_group: String?,
    val image: DoggoImage,
    val life_span: String,
    val name: String,
    val origin: String?,
    val temperament: String,
    val country_code: String?
) : Parcelable

@Parcelize
data class DoggoImage(val url: String) : Parcelable