package cn.stackflow.workbench.ui.layout.st

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import cn.stackflow.workbench.BuildConfig
import cn.stackflow.workbench.R
import cn.stackflow.workbench.common.base.BaseFragment
import cn.stackflow.workbench.common.glide.ImageLoader
import cn.stackflow.workbench.databinding.MeFragmentBinding
import cn.stackflow.workbench.ui.Constants
import cn.stackflow.workbench.ui.about.AboutActivity
import cn.stackflow.workbench.ui.account.ChangePwdActivity
import cn.stackflow.workbench.ui.setting.dept.DeptActivity
import cn.stackflow.workbench.ui.setting.role.RoleActivity
import cn.stackflow.workbench.ui.setting.user.UserActivity
import kotlinx.android.synthetic.main.home_toolbar.*
import kotlinx.android.synthetic.main.me_fragment.*
import kotlinx.android.synthetic.main.toolbar.view.*

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class MeFragment : BaseFragment<MeViewModel, MeFragmentBinding>(), View.OnClickListener {

    companion object {
        fun newInstance(): MeFragment {
            return MeFragment()
        }
    }

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)
        viewModel.loadUserInfo()
        viewModel.userLiveData.observe(this, Observer {
            tvName.text = it.name
            tvUsername.text = it.phone
            ImageLoader.displayImage(civAvatar, it.icon, R.drawable.btn_none)
        })

        toolbar.isVisible = true
        toolbar.tvTitle.text = ""
        updateUI()
        tvAppVersion.text = "V ${BuildConfig.VERSION_NAME}"

        rlUser.setOnClickListener(this)
        tvMenu1.setOnClickListener(this)
        tvMenu2.setOnClickListener(this)
        tvMenu3.setOnClickListener(this)
        tvMenu4.setOnClickListener(this)
        btnAbout.setOnClickListener(this)
    }

    private fun updateUI() {
        tvName.text = Constants.TAG
        tvUsername.text = "***********"
    }

    override fun getLayoutId(): Int {
        return R.layout.me_fragment
    }

    //-------------------------------

    private fun clickChangePassword() {
        startActivity(ChangePwdActivity::class.java)
    }

    private fun clickUser() {
        //TODO 点击用户信息逻辑
//        startLoginActivity()
        viewModel.loadUserInfo()
    }


    private fun clickAbout() {
        startActivity(AboutActivity::class.java)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.rlUser -> clickUser()
            R.id.tvMenu1 -> startActivity(DeptActivity::class.java)
            R.id.tvMenu2 -> startWebActivity("https://github.com/jenly1314", "GitHub")
            R.id.tvMenu3 -> startWebActivity("https://jenly1314.github.io", "Jenly")
//            R.id.tvMenu4 -> startWebActivity("https://developer.android.google.cn", "Android")            R.id.tvMenu2 -> startWebActivity("https://github.com/jenly1314", "GitHub")
//            R.id.tvMenu3 -> startActivity(RoleActivity::class.java)
            R.id.tvMenu4 -> startActivity(RoleActivity::class.java)
            R.id.tvMenu5 -> startActivity(UserActivity::class.java)
            R.id.btnAbout -> clickAbout()
        }
    }
}
