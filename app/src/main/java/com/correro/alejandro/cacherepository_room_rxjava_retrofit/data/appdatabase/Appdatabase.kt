package com.example.fitcel.fitcel.data.appdatabase.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.correro.alejandro.cacherepository_room_rxjava_retrofit.data.models.Result
import com.example.fitcel.fitcel.data.appdatabase.dao.ResultDao

@Database(entities = [Result::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun resultDao(): ResultDao
}