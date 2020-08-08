package cn.stackflow.workbench.ui.splash

import android.app.Application
import cn.stackflow.workbench.common.base.BaseModel
import cn.stackflow.workbench.common.base.BaseViewModel
import javax.inject.Inject

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class SplashViewModel @Inject constructor(application: Application, model: BaseModel?) : BaseViewModel(application, model){


    /**
     * 请求示例
     */
    fun getRequest(){
        launch {
            //TODO Http请求
//            val result = apiService.ge("").await()
//            //TODO 只需处理成功的场景，失败的场景都已统一处理
//            if(isSuccess(result)){
//
//            }
        }
    }
}