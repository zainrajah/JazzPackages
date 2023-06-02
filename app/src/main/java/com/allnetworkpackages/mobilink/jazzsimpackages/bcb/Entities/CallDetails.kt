package com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "CallDetails")
data class CallDetails(
    @PrimaryKey(autoGenerate = true)
    var ID: Int?= null,

    var Name: String? = null,

    var Details: String? = null,

    var ValidFor: String? = null,

    var Volume: String? = null,

    var Price: String? = null,

    var Code: String? = null,
)
