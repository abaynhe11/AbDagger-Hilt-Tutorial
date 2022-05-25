package com.google.firebase.quickstart.auth.abdagger_hilt_tutorial.data.api
import com.google.firebase.quickstart.auth.abdagger_hilt_tutorial.data.model.User
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>
}