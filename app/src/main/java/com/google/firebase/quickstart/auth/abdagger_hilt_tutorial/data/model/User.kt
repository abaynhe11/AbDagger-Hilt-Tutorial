package com.google.firebase.quickstart.auth.abdagger_hilt_tutorial.data.model

import com.squareup.moshi.Json


data class User(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "name")
    val name: String = "",
    @Json(name = "email")
    val email: String = "",
    @Json(name = "avatar")
    val avatar: String = ""
)