package cn.stackflow.workbench.common.api

import cn.stackflow.workbench.common.bean.*
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

    @GET("system/user")
    fun getUserList(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Call<Result<PageDTO<List<UserDTO>>>>


    @GET("system/resource/menu")
    fun getResource(@Query("menuType") resourceType: ResourceType): Call<Result<List<ResourceDTO>>>

    @GET("contract/self/list")
    fun getContract(
        @Query("page") page: Int,
        @Query("size") size: Int,
        @Query("listType") listType: Int,
        @Query("auditStatus") auditStatus: String?
    ): Call<Result<PageDTO<List<ContractDTO>>>>

    @GET("contract/self/search")
    fun getContract(@Part("q") q: String): Call<Result<List<ContractDTO>>>


    @GET("system/dept")
    fun getDeptList(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Call<Result<PageDTO<List<DeptDTO>>>>

    @GET("system/role")
    fun getRoleList(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Call<Result<PageDTO<List<RoleDTO>>>>


    @PUT("system/dept")
    fun updateDept(@Body deptDTO: DeptDTO): Call<Result<String>>


    @POST("system/dept")
    fun addDept(@Body deptDTO: DeptDTO): Call<Result<String>>


}