package cn.stackflow.workbench.ui.setting.user

import android.app.Application
import cn.stackflow.workbench.common.base.BaseModel
import cn.stackflow.workbench.common.base.ListViewModel
import cn.stackflow.workbench.common.bean.DeptDTO
import cn.stackflow.workbench.common.bean.RoleDTO
import cn.stackflow.workbench.common.bean.UserDTO
import retrofit2.await
import javax.inject.Inject

class UserViewModel @Inject constructor(application: Application, model: BaseModel?) :
    ListViewModel<UserDTO>(application, model) {


    override suspend fun request(curPage: Int, pageSize: Int) {
            val result = apiService.getUserList(curPage, pageSize).await()
            if (isSuccess(result)) {
                var rows = result.data?.rows
                rows?.let {
                    liveData.value = it
                }
            }
    }

}
