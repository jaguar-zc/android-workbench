package cn.stackflow.workbench.ui.setting

import android.app.Application
import androidx.lifecycle.MutableLiveData
import cn.stackflow.workbench.common.base.BaseModel
import cn.stackflow.workbench.common.base.BaseViewModel
import cn.stackflow.workbench.common.bean.DeptDTO
import retrofit2.await
import javax.inject.Inject

class DeptEditViewModel @Inject constructor(application: Application, model: BaseModel?) :
    BaseViewModel(application, model) {


    val refreshUI by lazy { MutableLiveData<Boolean>() }

    fun update(id: String, name: String, remark: String) {

        launch {
            var await = apiService.updateDept(DeptDTO(id,null,null,name,remark)).await();
            if (isSuccess(await)) {
                refreshUI.value = true
            }

        }



    }

    fun add(name: String, remark: String) {
        launch {

            var await = apiService.addDept(DeptDTO(null,null,null,name,remark)).await();
            if (isSuccess(await)) {
                refreshUI.value = true
            }
        }
    }


}