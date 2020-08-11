package cn.stackflow.workbench.common.config

import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import cn.stackflow.workbench.App
import cn.stackflow.workbench.common.receiver.CMDBroadcastReceiver
import cn.stackflow.workbench.ui.Constants
import cn.stackflow.workbench.common.util.Cache
import cn.stackflow.workbench.ui.account.LoginActivity
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        // 获得请求实例
        var request = chain.request() .newBuilder()
            //在header中添加新的参数
            .header("Authorization", Cache.getString(Constants.LOGIN_TOKEN,""))
            .build()
        //继续发送原始请求
        var proceed = chain.proceed(request)
        if (proceed.code() == 401) {
            var intent = Intent(CMDBroadcastReceiver.ACTION)
            LocalBroadcastManager.getInstance(App.application).sendBroadcast(intent)
        }
        return proceed
    }
}