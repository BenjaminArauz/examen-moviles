package com.example.kotlin.examen.framework.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.examen.utils.Constants
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenViewModel : ViewModel() {
    val acaboCargar = MutableLiveData<Boolean>()

    fun onCreate() {
        acaboCargar.postValue(false)
        viewModelScope.launch {
            delay(Constants.DURACION_SPLASHCREEN)
            acaboCargar.postValue(true)
        }
    }
}
