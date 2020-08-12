package cn.stackflow.workbench.common.config

import android.content.ComponentName
import android.content.Intent
import cn.stackflow.workbench.App
import cn.stackflow.workbench.common.receiver.CMDBroadcastReceiver
import cn.stackflow.workbench.common.util.Cache
import cn.stackflow.workbench.ui.Constants
import com.orhanobut.logger.Logger
import okhttp3.Interceptor
import okhttp3.Response


class TokenInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        Logger.d("TokenInterceptor")
        // 获得请求实例
        var request = chain.request() .newBuilder()
            //在header中添加新的参数
            .header("Authorization", Cache.getString(Constants.LOGIN_TOKEN,""))
            .build()
        //继续发送原始请求
        var proceed = chain.proceed(request)
        if (proceed.code() == 401) {
            var intent = Intent(CMDBroadcastReceiver.ACTION)
            intent.putExtra("cmd","logout");
            intent.component = ComponentName(App.application, CMDBroadcastReceiver::class.java)
            App.application.sendBroadcast(intent)
            Logger.d("TokenInterceptor：sendBroadcast ->"+CMDBroadcastReceiver.ACTION)
        }
        return proceed
    }
}