package com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "DataPackages")
data class DataPackages(
    @PrimaryKey(autoGenerate = true)
    var ID:Int?=null,
    var Heading:String?=null,
    var Validity:String?=null,
    var Sms:String?=null,
    var OnnetMinutes:String?=null,
    var Mbs:String?=null,
    var Rupees:String?=null
)
