package com.example.madlevel6task1.model

data class ColourItem (
    var hex: String,
    var name: String
    )
{
    fun getImageUrl() = "http://singlecolorimage.com/get/$hex/1080x1080"
}