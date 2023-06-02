package com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "RangePackages")
data class RangePackages(
    @PrimaryKey(autoGenerate = true)
    var ID:Int?=null,
    var Heading:String?=null,
    var Validity:String?=null,
    var Sms:String?=null,
    var OnNetMinutes:String?=null,
    var MBs:String?=null,
    var Rupees:String?=null
)
