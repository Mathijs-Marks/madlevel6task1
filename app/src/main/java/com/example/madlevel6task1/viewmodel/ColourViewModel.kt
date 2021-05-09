package com.example.madlevel6task1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.madlevel6task1.model.ColourItem
import com.example.madlevel6task1.repository.ColourRepository

class ColourViewModel : ViewModel() {

    private val colourRepository = ColourRepository()

    // Use encapsulation to expose as LiveData
    val colourItems: LiveData<List<ColourItem>>
    get() = _colourItems

    private val _colourItems = MutableLiveData<List<ColourItem>>().apply {
        value = colourRepository.getColourItems()
    }
}