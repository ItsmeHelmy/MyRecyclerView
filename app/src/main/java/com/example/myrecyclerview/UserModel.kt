package com.example.myrecyclerview

import android.provider.ContactsContract.CommonDataKinds.Email

data class UserModel(
    val id: Int,
    val name: String,
    val username: String,
    val email: String
)
