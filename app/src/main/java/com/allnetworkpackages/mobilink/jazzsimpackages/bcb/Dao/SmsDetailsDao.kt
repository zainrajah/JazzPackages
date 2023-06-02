package com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities.SmsDetails


@Dao
interface SmsDetailsDao {
    @Query("Select * From SmsDetails")
    fun getSmsDetails(): LiveData<List<SmsDetails>>

    @Query("Select * from SmsDetails where ID = :i")
    fun getSmsById(i: Int): LiveData<List<SmsDetails>>
}