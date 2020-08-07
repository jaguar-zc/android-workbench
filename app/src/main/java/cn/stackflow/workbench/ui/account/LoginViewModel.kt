package cn.stackflow.workbench.app.account

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import cn.stackflow.workbench.App
import cn.stackflow.workbench.app.Constants.LOGIN_TOKEN
import cn.stackflow.workbench.app.base.BaseModel
import cn.stackflow.workbench.app.base.BaseViewModel
import cn.stackflow.workbench.bean.BannerBean
import cn.stackflow.workbench.bean.LoginReq
import cn.stackflow.workbench.util.Cache
import retrofit2.await
import javax.inject.Inject

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class LoginViewModel @Inject constructor(application: Application, model: BaseModel?) : BaseViewModel(application, model){


    val loginSuccessEnd by lazy { MutableLiveData<Boolean>()}

    /**
     * 密码登录
     */
    fun login(username: String,password: String){
        launch {
            var result = apiService.login(LoginReq(username, password)).await()
            Log.i("LoginViewModel",result?.getErrorMessage())
            if(isSuccess(result)){
                var loginResp = result.data
                Log.i("LoginViewModel",loginResp?.token)
                Cache.put(LOGIN_TOKEN,loginResp?.token)
                loginSuccessEnd.value = true
            }
        }
    }

    /**
     * 验证码登录
     */
    fun verifyCodeLogin(username: String,verifyCode: String){
        launch {
//            //TODO Http请求
//            val result = apiService.getRequest("").await()
//            //TODO 只需处理成功的场景，失败的场景都已统一处理
//            if(isSuccess(result)){
//
//            }
        }
    }

}