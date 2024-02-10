package com.example.odnoklassniki_dz2

import androidx.annotation.DrawableRes

data class Student (
    @DrawableRes val Image : Int,
    val Surname:String,
    val Name: String,
    val sexIsFemale : Boolean
    ): java.io.Serializable
