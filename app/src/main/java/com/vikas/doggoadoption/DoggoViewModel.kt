package com.vikas.doggoadoption

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vikas.doggoadoption.data.DoggoBreedResponseModel
import com.vikas.doggoadoption.data.DoggoImage
import com.vikas.doggoadoption.data.DoggoNavigation
import com.vikas.doggoadoption.repository.DoggoAdoptionRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DoggoViewModel : ViewModel() {

    private val repository by lazy {
        DoggoAdoptionRepository.getInstance()
    }

    private val screen = MutableLiveData<DoggoNavigation>(DoggoNavigation.HOME)

    private val _breed = MutableLiveData<List<DoggoBreedResponseModel>>()

    private val _recent = MutableLiveData<List<DoggoBreedResponseModel>>()

    fun liveBreedData(): LiveData<List<DoggoBreedResponseModel>> {
        return _breed
    }

    fun liveRecentSearchData(): LiveData<List<DoggoBreedResponseModel>> {
        return _recent
    }

    fun searchRecentData(text: String) {
        val search = _recent.value?.filter { it.name.contains(text) }
        if (text.isEmpty()) {
            _recent.value = _breed.value?.shuffled()
        } else {
            _recent.value = search
        }
    }

    fun observeScreen(): LiveData<DoggoNavigation> {
        return screen
    }

    fun fetchBreed() {
        viewModelScope.launch {
            repository.getBreeds().collect {
                if (it.isNotEmpty()) {
                    _breed.value = it.shuffled()
                    _recent.value = _breed.value?.shuffled()
                }
            }
        }
    }

    fun sampleBreed(): List<DoggoBreedResponseModel> {
        return arrayListOf<DoggoBreedResponseModel>().apply {
            add(
                DoggoBreedResponseModel(
                    "Toy",
                    DoggoImage("https://cdn2.thedogapi.com/images/-HgpNnGXl.jpg"),
                    "12 - 15 years",
                    "Alaskan Malamute",
                    "Germany, France",
                    "Friendly, Energetic, Obedient, Intelligent, Protective, Trainable",
                    "US"
                )
            )
        }
    }
}