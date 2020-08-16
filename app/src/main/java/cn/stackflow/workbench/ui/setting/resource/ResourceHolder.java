package cn.stackflow.workbench.ui.setting.resource;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.unnamed.b.atv.model.TreeNode;

import cn.stackflow.workbench.R;
import cn.stackflow.workbench.common.bean.ResourceDTO;
import cn.stackflow.workbench.common.util.FontHelper;

public class ResourceHolder extends TreeNode.BaseNodeViewHolder<ResourceDTO> {
    LinearLayout linearLayout;
    public ResourceHolder(Context context) {
        super(context);
    }

    public ResourceHolder(Context context, LinearLayout linearLayout) {
        super(context);
        this.linearLayout = linearLayout;
    }

    @Override
    public View createNodeView(TreeNode node, ResourceDTO value) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.resource_node,  linearLayout, false);
        TextView tvValue = (TextView) view.findViewById(R.id.tvIcon);
        TextView ivJump = (TextView) view.findViewById(R.id.ivJump);
        FontHelper.applyFont(context,ivJump);
        tvValue.setText(value.getTitle());
        if(value.getChildren() != null && value.getChildren().size() > 0){
            ivJump.setVisibility(View.VISIBLE);
        }else{
            ivJump.setVisibility(View.INVISIBLE);
        }
        return view;
    }

}