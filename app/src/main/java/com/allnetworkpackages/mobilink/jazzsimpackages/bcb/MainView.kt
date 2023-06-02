package com.allnetworkpackages.mobilink.jazzsimpackages.bcb

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Entities.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainView (context:Application):AndroidViewModel(context){


    var allCodes: LiveData<List<Codes>>
    var allCallDet: LiveData<List<CallDetails>>
    var allCallPackages :LiveData<List<CallPackages>>
    var allDataDetails :LiveData<List<DataDetails>>
    var allDataPackages :LiveData<List<DataPackages>>
    var allRangeDetails :LiveData<List<RangeDetails>>
    var allRangePackage :LiveData<List<RangePackages>>
    var allSmsDetails :LiveData<List<SmsDetails>>
    var allSmsPackage :LiveData<List<SmsPackages>>

    val repository: DataRepository

    init {
        val codedao = DataDatabase.invoke(context).getCodeDao()
        val CallDetailsdao = DataDatabase.invoke(context).getCallDetail()
        val CallPackagesdao = DataDatabase.invoke(context).getCallPackages()
        val DataDetails = DataDatabase.invoke(context).getDataDetailsDao()
        val DataPackages = DataDatabase.invoke(context).getDataPackages()
        val RangeDetail = DataDatabase.invoke(context).getRangeDetails()
        val RangePackage = DataDatabase.invoke(context).getRangePackages()
        val SmsDetails = DataDatabase.invoke(context).getSmsDetails()
        val SmsPackage = DataDatabase.invoke(context).getSmsPackages()

        repository = DataRepository(
            codedao,
            CallDetailsdao,
            CallPackagesdao,
            DataDetails,
            DataPackages,
            RangeDetail,
            RangePackage,
            SmsDetails,
            SmsPackage
        )
        allCodes = repository.getCodeData
        allCallDet = repository.getCalldetails
        allCallPackages = repository.getCallPackages
        allDataDetails =repository.getDataDetails
        allDataPackages =repository.getDataPackage
        allRangeDetails=repository.getRangeDetails
        allRangePackage =repository.getRangePackage
        allSmsDetails =repository.getSmsDetails
        allSmsPackage =repository.getSmsPackage

    }

    fun insertWords(CodesEntity: Codes) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertWord(CodesEntity )
        }

//    fun deleteSearchedHistory() = viewModelScope.launch(Dispatchers.IO) {
//        repository.deleteData()
//    }
}