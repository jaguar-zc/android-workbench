package cn.stackflow.workbench.ui.layout.msg

import android.app.Application
import androidx.lifecycle.MutableLiveData
import cn.stackflow.workbench.common.base.BaseModel
import cn.stackflow.workbench.common.base.BaseViewModel
import cn.stackflow.workbench.common.bean.BannerBean
import cn.stackflow.workbench.common.bean.ContractDTO
import kotlinx.coroutines.delay
import retrofit2.await
import javax.inject.Inject

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class MsgViewModel @Inject constructor(application: Application, model: BaseModel?) : BaseViewModel(application, model){


    val liveDataBanner by lazy { MutableLiveData<List<BannerBean>>()}

    val liveData by lazy { MutableLiveData<List<ContractDTO>>()}

    fun getRequestBanner(){
        launch(false) {
            //TODO 模拟请求
            val data = arrayOf(
                "https://jenly1314.gitee.io/medias/banner/1.jpg",
                "https://jenly1314.gitee.io/medias/banner/2.jpg",
                "https://jenly1314.gitee.io/medias/banner/3.jpg",
                "https://jenly1314.gitee.io/medias/banner/4.jpg"
            )
            delay(1000)
            liveDataBanner.value = data.map {
                BannerBean(
                    it
                )
            }
        }
    }

    fun getRequestData(curPage: Int,pageSize : Int){
        //TODO 模拟请求
        launch {
//            var start = (curPage - 1) * pageSize + 1
//            var end = (curPage) * pageSize
//            if(curPage > 1){
//                end -= pageSize / 2
//            }
//            var data = ArrayList<Bean>()
//            for(index in start..end){
//                var bean = Bean()
//                with(bean){
//                    title = "列表模板标题示例$index"
//                    content = "列表模板内容示例$index"
//                    imageUrl = "http://jenly1314.gitee.io/medias/banner/${index % 7}.jpg"
//                }
//                data.add(bean)
//            }
//            delay(1000)

            var result = apiService.getContract(curPage, pageSize, 2, null).await()
            liveData.value = result.data?.rows
        }
    }


    /**
     * 请求示例
     */
    fun getRequest(){
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