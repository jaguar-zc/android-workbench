package cn.stackflow.workbench.ui.layout.audit

import android.os.Bundle
import androidx.core.view.isVisible
import cn.stackflow.workbench.R
import cn.stackflow.workbench.common.base.BaseFragment
import cn.stackflow.workbench.common.base.ListFragment
import cn.stackflow.workbench.common.bean.ContractDTO
import cn.stackflow.workbench.databinding.MenuFragmentBinding
import cn.stackflow.workbench.ui.adapter.BaseBindingAdapter
import cn.stackflow.workbench.ui.layout.doc.DocFragment
import cn.stackflow.workbench.ui.layout.doc.DocViewModel
import kotlinx.android.synthetic.main.home_toolbar.*
import kotlinx.android.synthetic.main.menu_fragment.*

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class AuditFragment: ListFragment<ContractDTO, DocViewModel>() {

    companion object{
        fun newInstance(): DocFragment {
            return DocFragment()
        }
    }

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)
        toolbar.isVisible = false
    }

    override fun getLayoutId(): Int {
        return R.layout.doc_fragment
    }

    override fun createAdapter(): BaseBindingAdapter<ContractDTO> {
        return BaseBindingAdapter(R.layout.doc_item)
    }
}