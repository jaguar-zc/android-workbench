package cn.stackflow.workbench.ui.setting.dept

import android.app.Application
import cn.stackflow.workbench.common.base.BaseModel
import cn.stackflow.workbench.common.base.ListViewModel
import cn.stackflow.workbench.common.bean.DeptDTO
import retrofit2.await
import javax.inject.Inject

class DeptViewModel @Inject constructor(application: Application, model: BaseModel?) :
    ListViewModel<DeptDTO>(application, model) {


    override suspend fun request(curPage: Int, pageSize: Int) {
            val result = apiService.getDeptList(curPage, pageSize).await()
            if (isSuccess(result)) {
                var rows = result.data?.rows
                rows?.let {
                    liveData.value = it
                }
            }
    }

}
