package com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities.Codes



@Dao
interface DataDao {

  @Insert
  fun codeEntity(code: Codes)

  @Query("Select * from Codes")
  fun getCodes(): LiveData<List<Codes>>



//  @Insert
//  fun callDetailsEntity(callDet: CallDetailsold)

//  @Query("Select * from CallDetails")
//  fun getCallDetail(): LiveData<List<CallDetailsold>>



//  @Query("Delete From Codes")
//  fun deleteAll()

  /*  @Query("SELECT * FROM Codes ")
    fun getCallDetails(): List<Codes>*/
/*
    @Query("INSERT INTO PackageData(MainHeadind,SubHeading,OnNetMinutes,Sms,Mbs,Rs)" +
            " VALUES(:Heading,:Validity,:Sms,:On_Net_Minutes,:MBs,:Rupees) ")

    fun getData(): LiveData<List<SmsPackages>>
*/
//  @get:Query("SELECT * FROM CallDetails")
//  val allProducts: List<CallDetails?>?

   /* @Query("SELECT * FROM CallDetails ")
    fun  getPackages(): List<CallDetails>*/

//       @Query("SELECT * FROM CallPackages ")
//       fun  getCallPackages(): List<CallPackages>
//
//      @Query("SELECT * FROM CallPackages ")
//       fun getCallDetails(): LiveData<List<CallPackages>>
//
//       @Query("Select * From SmsPackages")
//       fun getSmsPackages():LiveData<List<SmsPackages>>
//
//       @Query("Select * From SmsDetails")
//       fun getSmsDetails():LiveData<List<SmsDetails>>
//
//       @Query("Select * From DataPackages")
//       fun getDataPackages():LiveData<List<DataPackages>>
//
//       @Query("Select * From DataDetails")
//       fun getDataDetails():LiveData<List<DataDetails>>
//
//
//       @Query("Select * From '3G/4GPackages'")
//     fun getRange():LiveData<List<RangePackages>>
//
//   @Query("Select * From '3G/4GDetails'")
//    fun getRangeDetail(): LiveData<List<RangeDetails>>
//
//    @Query("Select * From Codes")
//    fun getCodes():LiveData<List<Codes>>

}