package com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CallPackages")
data class CallPackages(
    @PrimaryKey(autoGenerate = true)
    var ID: Int?=null,
    var OnnetMinutes: String?=null,
    var Heading: String?=null,
    var Rupees: String?=null,
    var Sms: String?=null,
    var Validity: String?=null,
    var MBs: String?=null,

)