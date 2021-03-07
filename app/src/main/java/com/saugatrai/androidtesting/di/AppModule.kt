package com.saugatrai.androidtesting.di

import android.content.Context
import androidx.room.Room
import com.saugatrai.androidtesting.data.local.ShoppingDao
import com.saugatrai.androidtesting.data.local.ShoppingItemDatabase
import com.saugatrai.androidtesting.data.remote.PixabayAPI
import com.saugatrai.androidtesting.other.Constants.BASE_URL
import com.saugatrai.androidtesting.other.Constants.DATABASE_NAME
import com.saugatrai.androidtesting.repository.DefaultShoppingRepository
import com.saugatrai.androidtesting.repository.ShoppingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideShoppingItemDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, ShoppingItemDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDefaultShoppingRepository(
        dao: ShoppingDao,
        api: PixabayAPI
    ) = DefaultShoppingRepository(dao, api) as ShoppingRepository

    @Singleton
    @Provides
    fun provideShoppingDao(
        database: ShoppingItemDatabase
    ) = database.shoppingDao()

    @Singleton
    @Provides
    fun providePixabayApi(): PixabayAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PixabayAPI::class.java)
    }
}