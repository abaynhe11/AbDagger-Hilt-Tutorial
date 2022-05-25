package com.google.firebase.quickstart.auth.abdagger_hilt_tutorial.data.repository
import com.google.firebase.quickstart.auth.abdagger_hilt_tutorial.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getUsers() =  apiHelper.getUsers()

}