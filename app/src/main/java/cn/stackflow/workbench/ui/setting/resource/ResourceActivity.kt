package cn.stackflow.workbench.ui.setting.resource

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import cn.stackflow.workbench.R
import cn.stackflow.workbench.common.base.BaseActivity
import cn.stackflow.workbench.common.bean.ResourceDTO
import cn.stackflow.workbench.databinding.ResourceActivityBinding
import com.unnamed.b.atv.model.TreeNode
import com.unnamed.b.atv.view.AndroidTreeView
import kotlinx.android.synthetic.main.resource_activity.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbar.view.*


/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class ResourceActivity : BaseActivity<ResourceViewModel, ResourceActivityBinding>(),
    TreeNode.TreeNodeClickListener {


    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)
        setToolbarTitle("资源管理")
        toolbar.ivRight.setImageResource(R.drawable.push)

//        val root = TreeNode.root()
//        val parent = TreeNode("MyParentNode")
//        val child0 = TreeNode("ChildNode0")
//        val child1 = TreeNode("ChildNode1")
//        parent.addChildren(child0, child1)
//        root.addChild(parent)
//        val tView = AndroidTreeView(context, root)
//        srl.addView(tView.view)

        viewModel.liveData.observe(this, Observer {
            refreshTreeView(it)
        })
        viewModel.requestData(1)

//        val nodeItem = IconTreeItem()
//        val child1 =  TreeNode(nodeItem).setViewHolder(ResourceHolder(context))

    }


    private fun createChildrenNote(resourceDTO: ResourceDTO): TreeNode {
        var treeNode = TreeNode(resourceDTO)
        treeNode.viewHolder = ResourceHolder(context, llView);
        treeNode.clickListener = this
        return treeNode;
    }


    private fun refreshTreeView(list: List<ResourceDTO>) {
        val root = TreeNode.root()
        list.forEach { it ->
            it.level = 1
            it.leaf = isLeaf(it)
            val parent = createChildrenNote(it)
            it.children.forEach { ii ->
                run {
                    ii.level = 2
                    ii.leaf = isLeaf(ii)
                    parent.addChild(createChildrenNote(ii))
                }
            }
            root?.addChild(parent)
        }
        val tView = AndroidTreeView(this, root)
        llView.addView(tView.view)
    }

    private fun isLeaf(resourceDTO: ResourceDTO): Int {
        return if (resourceDTO.children != null && resourceDTO.children.isNotEmpty()) {
            0
        } else {
            1
        }
    }


    override fun getLayoutId(): Int {
        return R.layout.resource_activity
    }


    override fun onClick(v: View) {
        super.onClick(v)
        if (v.id == R.id.ivRight) {
//            var intent = Intent(this,
//                DeptEditActivity::class.java)
//            startActivity(intent)
        }
    }

    override fun onClick(node: TreeNode?, value: Any?) {
        var resourceDTO = value as ResourceDTO
        resourceDTO.open = ! resourceDTO.open

        var     resourceHolder = node?.viewHolder as ResourceHolder

        var ivIcon = resourceHolder.view.findViewWithTag<TextView>(value.id)
        if (value.open) {
            ivIcon.setText(R.string.iconfont_tongyong_jiantouxiangxia)
        } else {
            ivIcon.setText(R.string.iconfont_tongyong_jiantouxiangyou)
        }

    }

}