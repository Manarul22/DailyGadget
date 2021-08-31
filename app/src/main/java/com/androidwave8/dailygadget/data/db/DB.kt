package com.androidwave8.dailygadget.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Gadget::class], version = 1)
abstract class DB: RoomDatabase() {
    abstract fun gadgetsDao(): GadgetsDao
}