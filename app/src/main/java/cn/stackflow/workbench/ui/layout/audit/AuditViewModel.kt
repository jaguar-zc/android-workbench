package cn.stackflow.workbench.ui.layout.audit

import android.app.Application
import cn.stackflow.workbench.common.base.BaseModel
import cn.stackflow.workbench.common.base.BaseViewModel
import cn.stackflow.workbench.common.base.ListViewModel
import cn.stackflow.workbench.common.bean.ContractDTO
import retrofit2.await
import javax.inject.Inject

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class AuditViewModel @Inject constructor(application: Application, model: BaseModel?) :
    ListViewModel<ContractDTO>(application, model) {

    override suspend fun request(curPage: Int, pageSize: Int) {

        var result = apiService.getContract(curPage, pageSize, 2, null).await()
        liveData.value = result.data?.rows
    }

}