package csoc.glgs.com.navigationexample

import android.app.Application

/**
 * 作者　: hegaojian
 * 时间　: 2019/12/23
 * 描述　:
 */

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

    }

}
