package com.allnetworkpackages.mobilink.jazzsimpackages.bcb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Dao.*
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities.*



// arrayOf(CallPackages::class, CallDetails::class, SmsPackages::class, SmsDetails::class,
//    RangeDetails::class,RangePackages::class,Codes::class,DataDetails::class, DataPackages::class)
@Database(entities = arrayOf(
    CallDetails::class, CallPackages::class,
DataDetails::class, DataPackages::class, RangeDetails::class, RangePackages::class,
SmsDetails::class,SmsPackages::class,Codes::class), version = 1, exportSchema = true)
abstract class DataDatabase : RoomDatabase() {

    abstract fun getCodeDao(): DataDao
    abstract fun getCallDetail(): CallDetailsDao
    abstract fun getCallPackages(): CallPackagesDao
    abstract fun getDataDetailsDao(): DataDetailsDao
    abstract fun getDataPackages(): DataPackagesDao
    abstract fun getRangePackages(): RangePackagesDao
    abstract fun getRangeDetails(): RangeDetailsDao
    abstract fun getSmsDetails(): SmsDetailsDao
    abstract fun getSmsPackages(): SmsPackagesDao



    companion object {
        @Volatile
        private var instance: DataDatabase? = null
        private val LOCK = Any()


        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                DataDatabase::class.java,
                "jazz"
            ).createFromAsset("jazzPackages.db")
                .build()
    }
}
