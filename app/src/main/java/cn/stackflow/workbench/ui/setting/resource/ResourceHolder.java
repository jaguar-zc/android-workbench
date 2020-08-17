package cn.stackflow.workbench.ui.setting.resource;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.unnamed.b.atv.model.TreeNode;

import java.util.List;

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
        final View view = inflater.inflate(R.layout.resource_node, linearLayout, false);
        TextView tvText = (TextView) view.findViewById(R.id.tvText);
        TextView ivIcon = (TextView) view.findViewById(R.id.ivIcon);
        FontHelper.applyFont(context, ivIcon);
        tvText.setText(value.getTitle() + " - 子节点" + getChildrenSize(value.getChildren()) + "个");
        ivIcon.setTag(value.getId());
        if (value.getLeaf() == 1) {
            ivIcon.setVisibility(View.INVISIBLE);
        } else {
            ivIcon.setVisibility(View.VISIBLE);
        }
        if (value.getOpen()) {
            ivIcon.setText(R.string.iconfont_tongyong_jiantouxiangxia);
        } else {
            ivIcon.setText(R.string.iconfont_tongyong_jiantouxiangyou);
        }
        if (value.getLevel() > 1) {
            setMargins(ivIcon, value.getLevel() * 40, 0, 0, 0);
        }
        return view;
    }

    private Integer getChildrenSize(List<ResourceDTO> children) {
        if (children == null || children.size() == 0) {
            return 0;
        } else {
            return children.size();
        }
    }


    public static void setMargins(View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }

}