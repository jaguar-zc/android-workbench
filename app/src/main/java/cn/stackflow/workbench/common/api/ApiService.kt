package cn.stackflow.workbench.api

import cn.stackflow.workbench.bean.*
import retrofit2.Call
import retrofit2.http.*


/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@JvmSuppressWildcards
interface ApiService {

    @POST("login")
    fun login(@Body loginReq: LoginReq): Call<Result<LoginResp>>

    @GET("system/user/info")
    fun getUserInfo(): Call<Result<UserDTO>>

    @GET("system/resource/menu?menuType=ME")
    fun getResourceMenu(): Call<Result<ResourceDTO>>

    @GET("contract/self/list")
    fun getContract(
        @Part page: Int,
        @Part size: Int,
        @Part auditStatus: String
    ): Call<Result<PageDTO<ContractDTO>>>

    @GET("contract/self/search")
    fun getContract(@Part q: String): Call<Result<List<ContractDTO>>>


}