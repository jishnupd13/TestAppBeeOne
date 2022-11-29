package com.app.architecturepattern.data.remote.dto


import com.app.architecturepattern.domain.model.User
import com.google.gson.annotations.SerializedName

data class UserListResponseDto(
    @SerializedName("address")
    val address: Address,
    @SerializedName("company")
    val company: Company,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("profile_image")
    val profileImage: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("website")
    val website: String
)

data class Geo(
    @SerializedName("lat")
    val lat: String,
    @SerializedName("lng")
    val lng: String
)

data class Company(
    @SerializedName("bs")
    val bs: String?="",
    @SerializedName("catchPhrase")
    val catchPhrase: String?="",
    @SerializedName("name")
    val name: String?=""
)

data class Address(
    @SerializedName("city")
    val city: String,
    @SerializedName("geo")
    val geo: Geo,
    @SerializedName("street")
    val street: String,
    @SerializedName("suite")
    val suite: String,
    @SerializedName("zipcode")
    val zipcode: String
)

fun UserListResponseDto.toUser(): User {
    return User(
        id = id,
        name = name,
        email = email,
        phone = phone,
        company = company
    )
}