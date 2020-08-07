package cn.stackflow.workbench.config

import android.content.Context
import cn.stackflow.workbench.app.Constants
import com.king.base.baseurlmanager.BaseUrlManager
import com.king.frame.mvvmframe.config.FrameConfigModule
import com.king.frame.mvvmframe.di.module.ConfigModule
import okhttp3.Interceptor

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class AppConfigModule : FrameConfigModule() {
    override fun applyOptions(context: Context, builder: ConfigModule.Builder) {
        if(Constants.isDomain){
            val manager = BaseUrlManager(context)
            builder.baseUrl(manager.baseUrl)
        }else{
            builder.baseUrl(Constants.BASE_URL)
        }
        builder.okHttpClientOptions{
            it.addInterceptor(TokenInterceptor())
        }
    }
}