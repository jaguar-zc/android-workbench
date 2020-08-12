package cn.stackflow.workbench.ui.setting

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.Observer
import cn.stackflow.workbench.R
import cn.stackflow.workbench.ui.Constants
import cn.stackflow.workbench.common.base.BaseActivity
import cn.stackflow.workbench.common.util.CheckUtils
import cn.stackflow.workbench.databinding.DeptEditActivityBinding
import com.king.base.util.StringUtils
import kotlinx.android.synthetic.main.dept_edit_activity.*

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class DeptEditActivity : BaseActivity<DeptEditViewModel, DeptEditActivityBinding>() {

    var id: String? = null
    var name: String? = null
    var remark: String? = null

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)

        setToolbarTitle(getString(R.string.me_menu1))

        etName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                etName.isSelected = !TextUtils.isEmpty(s)
            }

        })
        etRemark.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                etRemark.isSelected = !TextUtils.isEmpty(s)
            }

        })
        setClickRightClearListener(etName)
        setClickRightClearListener(etRemark)



        id = intent.getStringExtra(Constants.KEY_ID)
        name = intent.getStringExtra(Constants.KEY_TITLE)
        remark = intent.getStringExtra(Constants.KEY_CONTENT)

        name?.let {
            etName.setText(it)
        }
        remark?.let {
            etRemark.setText(it)
        }

        viewModel.refreshUI.observe(this, Observer {
            showToast("保存成功")
            onBackPressed()
        })
    }

    override fun getLayoutId(): Int {
        return R.layout.dept_edit_activity
    }

    //-------------------------------

    private fun save() {
        if (!checkInput(etName, R.string.hint_dept_name)) {
            return
        }
        val name = etName.text.toString()
        val remark = etRemark.text.toString()
        if (StringUtils.isEmpty(id)) {
            viewModel.add(name, remark)
        }else{
            id?.let { viewModel.update(it, name, remark) }
        }

    }

    override fun onClick(v: View) {
        super.onClick(v)
        when (v.id) {
            R.id.btnCommit -> save()
        }
    }
}

