package com.allnetworkpackages.mobilink.jazzsimpackages.bcb.Ads
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.nativead.NativeAd
import java.util.*

object NativeMaster {
    var mNativeAd: NativeAd? = null
    var backPressNative: Any? = Any()
    var nativeShowTime: Long = 0
 public   var fbAdView: AdView? = null

    public var nativeAdMobHashMap: HashMap<String, NativeAd>? = HashMap()

}