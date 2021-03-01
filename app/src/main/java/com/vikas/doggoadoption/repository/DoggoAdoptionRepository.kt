package com.vikas.doggoadoption.repository

import com.vikas.doggoadoption.data.DoggoBreedResponseModel
import com.vikas.doggoadoption.network.DoggoApiConfig
import com.vikas.doggoadoption.network.DoggoApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class DoggoAdoptionRepository(private val doggoApiService: DoggoApiService) {

    companion object {

        fun getInstance(): DoggoAdoptionRepository {
            return DoggoAdoptionRepository(DoggoApiConfig.injectDoggoApiService())
        }

    }

    fun getBreeds(): Flow<List<DoggoBreedResponseModel>> {
        return flow {
            emit(doggoApiService.getBreeds())
        }.flowOn(Dispatchers.IO)
    }

}