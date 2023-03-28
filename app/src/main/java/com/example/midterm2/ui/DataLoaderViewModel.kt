package com.example.midterm2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.midterm2.data.UsersRepo
import com.example.midterm2.model.UserItemModel
import kotlinx.coroutines.launch

class DataLoaderViewModel : ViewModel() {

    private val _usersList: MutableLiveData<List<UserItemModel>> = MutableLiveData()
    val usersList: LiveData<List<UserItemModel>> = _usersList


    fun loadUsers() {
        viewModelScope.launch {
            _usersList.postValue(UsersRepo().loadUsers())
        }
    }


}