package com.rishabh.todoapp.data.di

import android.content.Context
import androidx.room.Room
import com.rishabh.todoapp.data.model.TODODatabase
import com.rishabh.todoapp.data.model.TodoDAO
import com.rishabh.todoapp.utils.TODO_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/***
This Provides the Database Dependency to the Classes
1. Using @Provides as itc annot be constructor injected, as the Room classes is not owned.
2. @Binds will help to do the interface inject
This will be a Singleton Injection as we don't want the DB instance to be created many times
 */

// Using InstallIn to mention the Dependency Injection Level i.e. Singleton in case of DB
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    // provides the Database
    // Connect the Database class with the fun
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        TODODatabase::class.java,
        TODO_DATABASE_NAME
    ).build()

    // Adding the Database class to teh DAO
    @Singleton
    @Provides
    fun providesDAO(todoDatabase: TODODatabase) {
        todoDatabase.toDodo()
    }
}