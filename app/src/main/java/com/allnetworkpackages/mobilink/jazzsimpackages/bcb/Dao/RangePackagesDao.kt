package com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities.RangePackages


@Dao
interface RangePackagesDao {
    @Query("Select * From `RangePackages`")
    fun getRangePackages():LiveData<List<RangePackages>>
}