package com.example.masta_chef.Classes

import androidx.lifecycle.ViewModel

class SelectedItems:ViewModel() {
    var selectedFoodList = mutableListOf<Food_Items>()

    fun completedItemList (): List<Food_Items>{
        return selectedFoodList
    }
}