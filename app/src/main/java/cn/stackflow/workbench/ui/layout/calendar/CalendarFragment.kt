package cn.stackflow.workbench.ui.layout

import android.os.Bundle
import androidx.core.view.isVisible
import cn.stackflow.workbench.R
import cn.stackflow.workbench.databinding.CalendarFragmentBinding
import cn.stackflow.workbench.ui.base.BaseFragment
import cn.stackflow.workbench.databinding.MenuFragmentBinding
import kotlinx.android.synthetic.main.home_toolbar.*
import kotlinx.android.synthetic.main.menu_fragment.*

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class CalendarFragment(var text: String, var showToolbar: Boolean) : BaseFragment<MenuViewModel, CalendarFragmentBinding>() {

    companion object{
        fun newInstance(text: String,showToolbar: Boolean = true): CalendarFragment {
            return CalendarFragment(
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
        return R.layout.calendar_fragment
    }
}