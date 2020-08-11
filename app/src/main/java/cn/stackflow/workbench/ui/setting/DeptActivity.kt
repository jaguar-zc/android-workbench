package cn.stackflow.workbench.ui.setting

import android.os.Bundle
import cn.stackflow.workbench.R
import cn.stackflow.workbench.common.base.ListActivity
import cn.stackflow.workbench.common.bean.DeptDTO
import cn.stackflow.workbench.ui.adapter.BaseBindingAdapter
import kotlinx.android.synthetic.main.toolbar.*

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class DeptActivity : ListActivity<DeptDTO, DeptViewModel>() {

    override fun createAdapter(): BaseBindingAdapter<DeptDTO> {
        return BaseBindingAdapter(R.layout.dept_item)
    }

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)

        toolbar.title = "部门管理"
    }

    override fun getLayoutId(): Int {
        return R.layout.dept_activity
    }

    override fun clickItem(data: DeptDTO) {
        data.name?.let { showToast(it) }

    }
}