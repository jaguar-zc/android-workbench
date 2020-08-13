package cn.stackflow.workbench.ui.layout

import android.os.Bundle
import androidx.core.view.isVisible
import cn.stackflow.workbench.R
import cn.stackflow.workbench.common.base.BaseFragment
import cn.stackflow.workbench.databinding.WorkbeanchFragmentBinding
import cn.stackflow.workbench.ui.layout.audit.AuditViewModel
import kotlinx.android.synthetic.main.home_toolbar.toolbar
import kotlinx.android.synthetic.main.menu_fragment.*
import kotlinx.android.synthetic.main.toolbar.view.*

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class WorkbenchFragment(var text: String, var showToolbar: Boolean) : BaseFragment<AuditViewModel, WorkbeanchFragmentBinding>() {

    companion object{
        fun newInstance(text: String,showToolbar: Boolean = true): WorkbenchFragment {
            return WorkbenchFragment(
                text,
                showToolbar
            )
        }
    }

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)

        toolbar.isVisible = showToolbar
        toolbar.tvTitle.setText(R.string.home_menu3)
        tv.text = text
    }

    override fun getLayoutId(): Int {
        return R.layout.workbeanch_fragment
    }
}