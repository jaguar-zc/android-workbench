package cn.stackflow.workbench.common.bean

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
open class Result<T> {
    var code : Int? = null
    var message : String? = null
    var data : T? = null
    fun isSuccess(): Boolean{
        return 200 == code
    }
    fun getErrorMessage() = message
    override fun toString(): String {
        return "Result(code=$code, errorMsg=$message, data=$data)"
    }
}