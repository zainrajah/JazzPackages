package com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities.DataDetails

@Dao
interface DataDetailsDao {
    @Query("Select * from DataDetails")
    fun getDataDetails() : LiveData<List<DataDetails>>

    @Query("Select * from DataDetails where ID = :i")
    fun getDataByID(i:Int):LiveData<List<DataDetails>>
}