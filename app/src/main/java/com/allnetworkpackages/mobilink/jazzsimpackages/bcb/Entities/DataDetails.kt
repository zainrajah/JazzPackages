package com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "DataDetails")
data class DataDetails(
    @PrimaryKey
    var ID:Int?=null,
    @ColumnInfo(name = "Name")
    var Name:String?=null,
    @ColumnInfo(name = "Details")
    var Details:String?=null,
    @ColumnInfo(name = "ValidFor")
    var validFor:String?=null,
    @ColumnInfo(name = "Volume")
    var Volume:String?=null,
    @ColumnInfo(name = "Price")
    var Price:String?=null,
    @ColumnInfo(name = "Code")
    var Code:String?=null
)
