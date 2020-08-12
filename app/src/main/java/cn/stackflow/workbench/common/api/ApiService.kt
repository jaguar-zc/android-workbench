package cn.stackflow.workbench.common.api

import cn.stackflow.workbench.common.bean.*
import retrofit2.Call
import retrofit2.http.*
import java.util.*


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
        @Part("page") page: Int,
        @Part("size") size: Int,
        @Part("auditStatus")  auditStatus: String
    ): Call<Result<PageDTO<ContractDTO>>>

    @GET("contract/self/search")
    fun getContract(@Part("q") q: String): Call<Result<List<ContractDTO>>>



    @GET("system/dept")
    fun getDeptList(  @Query("page") page: Int,
                      @Query("size") size: Int): Call<Result<PageDTO<List<DeptDTO>>>>


    @PUT("system/dept")
    fun updateDept( @Body deptDTO: DeptDTO) : Call<Result<String>>


    @POST("system/dept")
    fun addDept( @Body deptDTO: DeptDTO) : Call<Result<String>>


}