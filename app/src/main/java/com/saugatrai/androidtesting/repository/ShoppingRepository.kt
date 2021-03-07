package com.saugatrai.androidtesting.repository

import androidx.lifecycle.LiveData
import com.saugatrai.androidtesting.data.local.ShoppingItem
import com.saugatrai.androidtesting.data.remote.responses.ImageResponse
import com.saugatrai.androidtesting.other.Resource

interface ShoppingRepository {
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItems(): LiveData<List<ShoppingItem>>

    fun observeTotalPrice(): LiveData<Float>

    suspend fun searchForImage(imageQuery: String): Resource<ImageResponse>
}