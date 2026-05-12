package com.example.inventory.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(                    // đổi class -> data class
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val price: Double,
    val quantity: Int
)