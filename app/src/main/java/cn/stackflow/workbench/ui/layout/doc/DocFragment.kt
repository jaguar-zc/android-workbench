package cn.stackflow.workbench.ui.layout.doc

import android.os.Bundle
import androidx.core.view.isVisible
import cn.stackflow.workbench.R
import cn.stackflow.workbench.common.base.BaseFragment
import cn.stackflow.workbench.common.base.BaseModel
import cn.stackflow.workbench.common.base.ListFragment
import cn.stackflow.workbench.common.bean.ContractDTO
import cn.stackflow.workbench.databinding.DocFragmentBinding
import cn.stackflow.workbench.ui.adapter.BaseBindingAdapter
import kotlinx.android.synthetic.main.home_toolbar.*

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class DocFragment : ListFragment<ContractDTO,DocViewModel>() {

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