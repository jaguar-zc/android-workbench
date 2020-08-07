package cn.stackflow.workbench.ui.me

import android.app.Application
import androidx.lifecycle.MutableLiveData
import cn.stackflow.workbench.ui.base.BaseModel
import cn.stackflow.workbench.ui.base.BaseViewModel
import cn.stackflow.workbench.common.bean.BannerBean
import cn.stackflow.workbench.common.bean.UserDTO
import retrofit2.await
import javax.inject.Inject

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class MeViewModel @Inject constructor(application: Application, model: BaseModel?) :
    BaseViewModel(application, model) {

    val userLiveData by lazy { MutableLiveData<UserDTO>() }

    /**
     * 请求示例
     */
    fun loadUserInfo() {
        launch {
            val result = apiService.getUserInfo().await()
            if (isSuccess(result)) {
                userLiveData.value = result.data
            }

        }
    }

}