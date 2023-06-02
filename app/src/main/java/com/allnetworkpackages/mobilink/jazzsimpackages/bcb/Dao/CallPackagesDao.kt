package com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities.CallPackages


@Dao
interface CallPackagesDao {
    @Query("Select * From CallPackages")
    fun getCallPackages() : LiveData<List<CallPackages>>
}