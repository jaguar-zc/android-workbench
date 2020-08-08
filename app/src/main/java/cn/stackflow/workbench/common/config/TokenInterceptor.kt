package cn.stackflow.workbench.common.config

import cn.stackflow.workbench.ui.Constants
import cn.stackflow.workbench.common.util.Cache
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
        return chain.proceed(request)
    }
}