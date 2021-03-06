package com.google.firebase.quickstart.auth.abdagger_hilt_tutorial.ui.main.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.google.firebase.quickstart.auth.abdagger_hilt_tutorial.data.model.User
import com.google.firebase.quickstart.auth.abdagger_hilt_tutorial.data.repository.MainRepository
import com.google.firebase.quickstart.auth.abdagger_hilt_tutorial.utils.NetworkHelper
import kotlinx.coroutines.launch
import com.google.firebase.quickstart.auth.abdagger_hilt_tutorial.utils.Resource

class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _users = MutableLiveData<Resource<List<User>>>()
    val users: LiveData<Resource<List<User>>>
        get() = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _users.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getUsers().let {
                    if (it.isSuccessful) {
                        _users.postValue(Resource.success(it.body()))
                    } else _users.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _users.postValue(Resource.error("No internet connection", null))
        }
    }
}