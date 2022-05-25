package com.google.firebase.quickstart.auth.abdagger_hilt_tutorial.data.api

import com.google.firebase.quickstart.auth.abdagger_hilt_tutorial.data.model.User
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getUsers(): Response<List<User>> = apiService.getUsers()

}