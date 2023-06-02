package com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "Codes")
data class Codes(
    @PrimaryKey(autoGenerate = true)
    var ID:Int?=null,
    @ColumnInfo(name = "Code")
    var Code:String?=null,
    @ColumnInfo(name = "Description")
    var Description :String?=null
)
