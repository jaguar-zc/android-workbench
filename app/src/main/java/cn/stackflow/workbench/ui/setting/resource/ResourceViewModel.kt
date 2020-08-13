package cn.stackflow.workbench.ui.setting.resource

import android.app.Application
import cn.stackflow.workbench.common.base.BaseModel
import cn.stackflow.workbench.common.base.ListViewModel
import cn.stackflow.workbench.common.bean.DeptDTO
import cn.stackflow.workbench.common.bean.ResourceDTO
import cn.stackflow.workbench.common.bean.ResourceType
import cn.stackflow.workbench.common.bean.RoleDTO
import retrofit2.await
import javax.inject.Inject

class ResourceViewModel @Inject constructor(application: Application, model: BaseModel?) :
    ListViewModel<ResourceDTO>(application, model) {


    override suspend fun request(curPage: Int, pageSize: Int) {
        val result = apiService.getResource(ResourceType.ALL).await()
        if (isSuccess(result)) {
            var rows = result.data
            rows?.let {
                liveData.value = it
            }
        }
    }

}
