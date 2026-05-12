package com.example.inventory.data

import kotlinx.coroutines.flow.Flow

interface ItemsRepository {
    fun getAllItemsStream(): Flow<List<Item>>
    fun getItemStream(id: Int): Flow<Item?>      // trả về Flow<Item?>, không phải Unit
    suspend fun insertItem(item: Item)           // suspend + kiểu đúng
    suspend fun updateItem(item: Item)           // suspend + kiểu đúng
    suspend fun deleteItem(item: Item)           // suspend + kiểu đúng
}