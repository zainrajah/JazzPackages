package com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities.DataPackages


@Dao
interface DataPackagesDao {
    @Query("Select * From DataPackages")
    fun getDataPackages() : LiveData<List<DataPackages>>
}