package cn.stackflow.workbench.common.base

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.home_toolbar.*
import kotlinx.android.synthetic.main.toolbar.view.*


/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class TabFragment(var block: (Int) -> Fragment,titles: Array<String>, var showToolbar: Boolean = false, var title: String = "") : BaseTabFragment(titles) {

    companion object{
        fun newInstance(block: (Int) -> Fragment,titles: Array<String>,showToolbar: Boolean = false,  title: String = ""): TabFragment {
            return TabFragment(
                block,
                titles,
                showToolbar,
                title
            )
        }
    }

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)
        toolbar.isVisible = showToolbar
        toolbar.tvTitle.text = title
    }

    override fun createTabItemFragment(position: Int) = block(position)

}