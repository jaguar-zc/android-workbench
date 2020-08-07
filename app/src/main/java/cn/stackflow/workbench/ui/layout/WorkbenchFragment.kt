package cn.stackflow.workbench.ui.layout

import android.os.Bundle
import androidx.core.view.isVisible
import cn.stackflow.workbench.R
import cn.stackflow.workbench.ui.base.BaseFragment
import cn.stackflow.workbench.databinding.MenuFragmentBinding
import cn.stackflow.workbench.databinding.WorkbeanchFragmentBinding
import kotlinx.android.synthetic.main.home_toolbar.*
import kotlinx.android.synthetic.main.menu_fragment.*

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class WorkbeanchFragment(var text: String, var showToolbar: Boolean) : BaseFragment<MenuViewModel, WorkbeanchFragmentBinding>() {

    companion object{
        fun newInstance(text: String,showToolbar: Boolean = true): WorkbeanchFragment {
            return WorkbeanchFragment(
                text,
                showToolbar
            )
        }
    }

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)

        toolbar.isVisible = showToolbar

        tv.text = text
    }

    override fun getLayoutId(): Int {
        return R.layout.workbeanch_fragment
    }
}