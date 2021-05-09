package com.example.madlevel6task1.repository

import com.example.madlevel6task1.model.ColourItem

class ColourRepository {

    fun getColourItems(): List<ColourItem> {
        return arrayListOf(
            ColourItem("000000", "Black"),
            ColourItem("FF0000", "Red"),
            ColourItem("0000FF", "Blue"),
            ColourItem("FFFF00", "Yellow"),
            ColourItem("008000", "Green")
        )
    }
}