package com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "SmsPackages")
data class SmsPackages(
    @PrimaryKey
    var ID:Int?=null,
    var Heading:String?=null,
    var Validity:String?=null,
    var Sms:String?=null,
    var OnNetMinutes:String?=null,
    var MBs:String?=null,
    var Rupees:String?=null,
)
