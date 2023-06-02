package com.allnetworkpackages.mobilink.jazzsimpackages.bcb

import androidx.lifecycle.LiveData
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Dao.*
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities.*


class DataRepository(private val DataDao: DataDao,
                     private val CallDetailDao: CallDetailsDao,
                     private val CallPackagesDao:CallPackagesDao,
                     private val DataDetailsDao: DataDetailsDao,
                     private val DataPackageDao:DataPackagesDao,
                     private val RangeDetailsDao: RangeDetailsDao,
                     private val RangePackagesDao: RangePackagesDao,
                     private val SmsDetailsDao: SmsDetailsDao,
                     private val SmsPackagesDao: SmsPackagesDao

                     ) {


     suspend fun insertWord(p: Codes) {
        DataDao.codeEntity(p)
    }

    val getCodeData: LiveData<List<Codes>> = DataDao.getCodes()
    val getCalldetails: LiveData<List<CallDetails>> = CallDetailDao.getCallDetail()
    val getCallPackages :LiveData<List<CallPackages>> = CallPackagesDao.getCallPackages()
    val getDataDetails : LiveData<List<DataDetails>> = DataDetailsDao.getDataDetails()
    val getDataPackage :LiveData<List<DataPackages>> = DataPackageDao.getDataPackages()
    val getRangeDetails:LiveData<List<RangeDetails>> = RangeDetailsDao.getRangeDetails()
    val getRangePackage :LiveData<List<RangePackages>> =RangePackagesDao.getRangePackages()
    val getSmsDetails:LiveData<List<SmsDetails>> = SmsDetailsDao.getSmsDetails()
    val getSmsPackage:LiveData<List<SmsPackages>> =SmsPackagesDao.getSmsPackages()






//    fun addData(data:SmsPackages){
//
//   //     DataDao.getCallDetails()
//    }
}