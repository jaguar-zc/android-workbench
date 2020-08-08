package cn.stackflow.workbench

import android.content.Context
import androidx.multidex.MultiDex
import cn.stackflow.workbench.common.di.compoent.DaggerApplicationComponent
import cn.stackflow.workbench.common.util.Cache
import cn.stackflow.workbench.ui.Constants
import com.king.base.baseurlmanager.BaseUrlManager
import com.king.base.baseurlmanager.bean.UrlInfo
import com.king.frame.mvvmframe.base.BaseApplication
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.scwang.smartrefresh.header.MaterialHeader
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import es.dmoral.toasty.Toasty
import timber.log.Timber

/**
 *
 */
class App : BaseApplication() {
    init {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
            layout.setPrimaryColorsId(
                R.color.colorPrimary,
                R.color.white
            )
            MaterialHeader(context)
        }
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout ->
            ClassicsFooter(context)
        }
    }

    val manager by lazy { BaseUrlManager(this) }

    override fun attachBaseContext(base: Context?) {
        //初始化打印日志
        var formatStrategy = PrettyFormatStrategy.newBuilder()
            .methodOffset(5)
            .tag(Constants.TAG)
            .build()

        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
//
//        Timber.plant(object : Timber.DebugTree() {
//            override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
//                if (BuildConfig.DEBUG) {
//                    Logger.log(priority, tag, message, t)
//                }
//            }
//        })

        super.attachBaseContext(base)

        MultiDex.install(base)
//        Beta.installTinker()

        Toasty.Config.getInstance().allowQueue(false).apply()
    }

    override fun onCreate() {
        if (Constants.isDomain) {//提供动态切换环境
            if (manager.count == 0) {
                manager.urlInfo = UrlInfo(Constants.BASE_URL)
            }
        }
        super.onCreate()
//        Bugly.init(
//            this, Constants.BUGLY_APP_ID,
//            BuildConfig.DEBUG
//        )

//        NeverCrash.init { t, e ->
//            CrashReport.postCatchedException(e)
//        }

        DaggerApplicationComponent.builder()
            .appComponent(appComponent)
            .build()
            .inject(this)
        Cache.initialize(this)
    }
}