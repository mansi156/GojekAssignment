package com.mansi.gojekassignment.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mansi.gojekassignment.data.api.ApiHelper
import com.mansi.gojekassignment.data.repository.MainRepository
import com.mansi.gojekassignment.ui.main.viewmodel.MainViewModel

class ViewModelFactory (private val apiHelper: ApiHelper): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw java.lang.IllegalArgumentException("Unknown class name")
    }
}
