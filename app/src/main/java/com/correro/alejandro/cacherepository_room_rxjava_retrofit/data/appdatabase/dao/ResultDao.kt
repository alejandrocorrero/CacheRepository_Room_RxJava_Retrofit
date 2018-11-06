package com.example.fitcel.fitcel.data.appdatabase.dao

import android.arch.persistence.room.*
import com.correro.alejandro.cacherepository_room_rxjava_retrofit.data.models.Result
import io.reactivex.Flowable
import io.reactivex.Observable

@Dao
interface ResultDao {

    @Query("SELECT * FROM result")
    fun getResult(): Flowable<List<Result>?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertResult(results:List<Result>)


}