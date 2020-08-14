package cn.stackflow.workbench.ui.setting.resource

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import cn.stackflow.workbench.R
import cn.stackflow.workbench.common.base.BaseActivity
import cn.stackflow.workbench.common.bean.ResourceDTO
import cn.stackflow.workbench.databinding.ResourceActivityBinding
import com.orhanobut.logger.Logger
import com.unnamed.b.atv.model.TreeNode
import com.unnamed.b.atv.view.AndroidTreeView
import kotlinx.android.synthetic.main.resource_activity.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbar.view.*


/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class ResourceActivity : BaseActivity<ResourceViewModel, ResourceActivityBinding>() {


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

        viewModel.liveData.observe(this,Observer {
            refreshTreeView(it)
        })


        viewModel.requestData(1)



//        val nodeItem = IconTreeItem()
//        val child1 =  TreeNode(nodeItem).setViewHolder(ResourceHolder(context))

    }





    private fun createChildrenNote(resourceDTO: ResourceDTO): TreeNode{
        return  TreeNode(resourceDTO).setViewHolder(ResourceHolder(context,llView));
    }


    private fun refreshTreeView(list: List<ResourceDTO>){
        val root = TreeNode.root()
        list.forEach { it ->
            val parent = TreeNode(it).setViewHolder(ResourceHolder(context,llView))
            it.children.forEach { ii ->
                run {
                    parent.addChild(createChildrenNote(ii))
                }
            }
            root?.addChild(parent)
        }
        val tView = AndroidTreeView(this, root)
        llView.addView(tView.view)
    }


    override fun getLayoutId(): Int {
        return R.layout.resource_activity
    }


    override fun onClick(v: View) {
        super.onClick(v)
        if(v.id == R.id.ivRight){
//            var intent = Intent(this,
//                DeptEditActivity::class.java)
//            startActivity(intent)
        }
    }

}