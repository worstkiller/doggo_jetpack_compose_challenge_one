package com.vikas.doggoadoption.data

sealed class DoggoNavigation {

    object HOME: DoggoNavigation()
    object HOME_DETAILS : DoggoNavigation()

}