package com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Ads

import org.koin.dsl.module

object AppModule {
    fun getModel(application:ApplicationClass): org.koin.core.module.Module {
        return module {
            single {
                TinyDB.getInstance(
                    get())
            }
        }
    }
}