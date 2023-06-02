package com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities.SmsPackages


@Dao
interface SmsPackagesDao {
    @Query("Select * From SmsPackages")
    fun getSmsPackages(): LiveData<List<SmsPackages>>

}