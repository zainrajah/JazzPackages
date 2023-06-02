package com.allnetworkpackages.mobilink.jazzsimpackages.bcb

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class viewmodelview(val application: Application) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = when (modelClass) {
        MainView::class.java -> MainView(application)

        else -> throw IllegalArgumentException("Unknown ViewModel class")
    } as T
}