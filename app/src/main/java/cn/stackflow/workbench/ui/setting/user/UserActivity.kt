package cn.stackflow.workbench.ui.setting.user

import android.os.Bundle
import android.view.View
import cn.stackflow.workbench.R
import cn.stackflow.workbench.common.base.ListActivity
import cn.stackflow.workbench.common.bean.UserDTO
import cn.stackflow.workbench.ui.adapter.BaseBindingAdapter
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbar.view.*

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class UserActivity : ListActivity<UserDTO, UserViewModel>() {

    override fun createAdapter(): BaseBindingAdapter<UserDTO> {
        return BaseBindingAdapter(R.layout.user_item)
    }

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)
        setToolbarTitle("用户管理")
        toolbar.ivRight.setImageResource(R.drawable.push)
    }

    override fun getLayoutId(): Int {
        return R.layout.user_activity
    }

    override fun clickItem(data: UserDTO) {
        data.name?.let {
//            showToast(it)
//            var intent = Intent(this,
//                DeptEditActivity::class.java)
//            intent.putExtra(Constants.KEY_ID,data.id)
//            intent.putExtra(Constants.KEY_TITLE,data.name)
//            intent.putExtra(Constants.KEY_CONTENT,data.remark)
//            startActivity(intent)
        }
    }

    override fun onClick(v: View) {
        super.onClick(v)
        if(v.id == R.id.ivRight){
//            var intent = Intent(this,
//                DeptEditActivity::class.java)
//            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        requestData(1)
    }

}