package cn.stackflow.workbench.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import cn.stackflow.workbench.R
import cn.stackflow.workbench.ui.Constants.LOGIN_TOKEN
import cn.stackflow.workbench.common.base.BaseActivity
import cn.stackflow.workbench.ui.layout.st.MeFragment
import cn.stackflow.workbench.common.base.TabFragment
import cn.stackflow.workbench.databinding.HomeActivityBinding
import cn.stackflow.workbench.common.util.Cache
import cn.stackflow.workbench.ui.layout.*
import cn.stackflow.workbench.ui.layout.audit.AuditFragment
import cn.stackflow.workbench.ui.layout.calendar.CalendarFragment
import cn.stackflow.workbench.ui.layout.doc.DocFragment
import cn.stackflow.workbench.ui.layout.msg.MsgFragment

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class MainActivity : BaseActivity<MainViewModel, HomeActivityBinding>() {

    var fragment1: Fragment? = null
    var fragment2: Fragment? = null
    var fragment3: Fragment? = null
    var fragment4: Fragment? = null
    var fragment5: Fragment? = null

    var lastTime: Long = 0

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)
        showFragment { getFragment1(it) }
        if (Cache.getString(LOGIN_TOKEN, "").isNullOrEmpty()) {
            startLoginActivity()
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.home_activity
    }

    override fun onBackPressed() {
        if (lastTime < System.currentTimeMillis() - Constants.DOUBLE_CLICK_EXIT_TIME) {
            lastTime = System.currentTimeMillis()
            showToast(R.string.tips_double_click_exit)
            return
        }
        super.onBackPressed()
    }


    private fun hideAllFragment(fragmentTransaction: FragmentTransaction) {
        hideFragment(fragmentTransaction, fragment1)
        hideFragment(fragmentTransaction, fragment2)
        hideFragment(fragmentTransaction, fragment3)
        hideFragment(fragmentTransaction, fragment4)
        hideFragment(fragmentTransaction, fragment5)
    }

    private fun hideFragment(fragmentTransaction: FragmentTransaction, fragment: Fragment?) {
        fragment?.let {
            fragmentTransaction.hide(it)
        }
    }

    private fun showFragment(block: (FragmentTransaction) -> Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        hideAllFragment(fragmentTransaction)
        fragmentTransaction.show(block(fragmentTransaction))
        fragmentTransaction.commit()
    }

    private fun getFragment1(fragmentTransaction: FragmentTransaction): Fragment {
        if (fragment1 == null) {
            fragment1 =
                MsgFragment.newInstance()
            fragment1?.let {
                fragmentTransaction.add(R.id.fragmentContent, it)
            }
        }
        return fragment1!!
    }

    private fun getFragment2(fragmentTransaction: FragmentTransaction): Fragment {
        if (fragment2 == null) {
            fragment2 =
                CalendarFragment.newInstance(
                    getString(R.string.home_menu2),false
                )
            fragment2?.let {
                fragmentTransaction.add(R.id.fragmentContent, it)
            }
        }
        return fragment2!!
    }

    private fun getFragment3(fragmentTransaction: FragmentTransaction): Fragment {
        if (fragment3 == null) {
            fragment3 =
                WorkbenchFragment.newInstance(
                    getString(R.string.home_menu3)
                )
            fragment3?.let {
                fragmentTransaction.add(R.id.fragmentContent, it)
            }
        }
        return fragment3!!
    }

    private fun getFragment4(fragmentTransaction: FragmentTransaction): Fragment {
        if (fragment4 == null) {
            fragment4 = TabFragment.newInstance({
                when (it) {
                    0 -> DocFragment.newInstance()
                    else -> AuditFragment.newInstance()
                }
            }, arrayOf("文档", "审核"), true,"文档")
            fragment4?.let {
                fragmentTransaction.add(R.id.fragmentContent, it)
            }
        }
        return fragment4!!
    }

    private fun getFragment5(fragmentTransaction: FragmentTransaction): Fragment {
        if (fragment5 == null) {
            fragment5 = MeFragment.newInstance()
            fragment5?.let {
                fragmentTransaction.add(R.id.fragmentContent, it)
            }
        }
        return fragment5!!
    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.rbMenu1 -> showFragment { getFragment1(it) }
            R.id.rbMenu2 -> showFragment { getFragment2(it) }
            R.id.rbMenu3 -> showFragment { getFragment3(it) }
            R.id.rbMenu4 -> showFragment { getFragment4(it) }
            R.id.rbMenu5 -> showFragment { getFragment5(it) }
        }
    }

}