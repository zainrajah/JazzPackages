package com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities.CallDetails


@Dao
interface CallDetailsDao {

    @Query("Select * from CallDetails")
    fun getCallDetail(): LiveData<List<CallDetails>>

    @Query("Select * from CallDetails where ID = :i")
    fun getCallById(i:Int): LiveData<List<CallDetails>>
}