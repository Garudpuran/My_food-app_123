package com.example.masta_chef.Data

import com.example.masta_chef.Classes.Food_Items
import com.example.masta_chef.R

class FoodItemDataResource {
    fun loadItems(): List<Food_Items> {
        return listOf<Food_Items>(
            Food_Items(
                R.drawable.pizza_250p,
                R.string.pizza_title,
                R.string.pizza_description,
                R.string.pizza_price
            ),
            Food_Items(
                R.drawable.biryani,
                R.string.biryani_title,
                R.string.biryani_description,
                R.string.biryani_price
            ),
            Food_Items(
                R.drawable.burger_250p,
                R.string.burger_title,
                R.string.burger_description,
                R.string.burger_price
            ),
            Food_Items(
                R.drawable.egg_roll_250p,
                R.string.eggRoll_title,
                R.string.eggRoll_description,
                R.string.eggRoll_price
            ),
            Food_Items(
                R.drawable.fish_250p,
                R.string.fish_title,
                R.string.fish_description,
                R.string.fish_price
            ),
            Food_Items(
                R.drawable.fried_chicken,
                R.string.fried_chicken_title,
                R.string.fried_chicken_description,
                R.string.fried_chicken_price
            ),
            Food_Items(
                R.drawable.noodles,
                R.string.noodles_title,
                R.string.noodles_description,
                R.string.noodles_price
            ),
            Food_Items(
                R.drawable.pancakes_250p,
                R.string.pancakes_title,
                R.string.pancakes_description,
                R.string.pancakes_price
            ),
            Food_Items(
                R.drawable.prawns_250p,
                R.string.prawns_title,
                R.string.prawns_description,
                R.string.prawns_price
            ),
            Food_Items(
                R.drawable.salad_250p,
                R.string.salad_title,
                R.string.salad_description,
                R.string.salad_price
            ),
            Food_Items(
                R.drawable.rosted_chicken,
                R.string.roasted_chicken_title,
                R.string.roasted_chicken_description,
                R.string.roasted_chicken_price
            )

        )

    }
}