package cn.stackflow.workbench.common.bean

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
data class Bean(
    var title: String? = null,
    var content: String? = null,
    var imageUrl: String? = null
)

data class LoginReq(var username: String, var password: String)
data class ResourceDTO(var key: String, var title: String, var children: List<ResourceDTO>)
data class LoginResp(var token: String)
data class PageDTO<T>(var page: Int, var size: Int, var data: T)
data class ContractDTO(
    var id: String,
    var contractNo: String,
    var contractTypeId: String,
    var contractTypeName: String,
    var tag: String,
    var name: String,
    var createTime: String,
    var previewImage: String,
    var auditDeptId: String,
    var auditDeptName: String,
    var auditStatus: Int,
    var createUserName: String,
    var createUserId: String
)

data class BannerBean(val imgUrl: String) :
    BannerImage {
    override fun getImageUrl(): String? {
        return imgUrl
    }
}

data class UserDTO(
    val id: String? = null,
    val username //账号
    : String? = null,
    val password //密码
    : String? = null,
    val name //姓名,
    : String? = null,
    val phone //手机号
    : String? = null,
    val icon //图标
    : String? = null,
    val deptId //部门
    : String? = null,
    val deptName //部门
    : String? = null,
    val enable // 0:禁用 1:启用
    : Int? = null,
    val roleList //角色
    : List<RoleDTO>? = null
)

data class RoleDTO(
    val id: String? = null,
    val name //角色名
    : String? = null,
    val remark //描述
    : String? = null
)


