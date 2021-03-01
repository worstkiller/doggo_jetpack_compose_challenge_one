package com.vikas.doggoadoption.data

sealed class DoggoNavigation {

    object HOME : DoggoNavigation()
    data class HomeDetails(val doggoBreedResponseModel: DoggoBreedResponseModel) : DoggoNavigation()

}