package com.example.midterm2.data

import com.google.gson.annotations.SerializedName

data class FullResponse(
    @SerializedName("results")
    val usersList: List<User>
)

data class User(
    @SerializedName("name")
    val name: Name,
    @SerializedName("email")
    val email: String?,
    @SerializedName("nat")
    val nat: String?
)

data class Name(
    @SerializedName("first")
    val first: String?,
    @SerializedName("last")
    val last: String?,
)
