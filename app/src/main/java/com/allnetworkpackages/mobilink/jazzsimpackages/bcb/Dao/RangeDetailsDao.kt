package com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities.RangeDetails


@Dao
interface RangeDetailsDao {
    @Query("Select * From RangeDetails")
    fun getRangeDetails() :LiveData<List<RangeDetails>>

    @Query("Select *  From RangeDetails where ID =:i")
    fun getRangeById(i:Int):LiveData<List<RangeDetails>>

}