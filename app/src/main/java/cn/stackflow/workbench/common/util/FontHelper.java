package cn.stackflow.workbench.common.util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.stackflow.workbench.ui.Constants;

import static android.content.ContentValues.TAG;

public class FontHelper {
    /**
     * Apply specified font for all text views (including nested ones) in the specified
     * root view.
     *
     * @param context
     *            Context to fetch font asset.
     * @param root
     *            Root view that should have specified font for all it's nested text
     *            views.
     * @param fontName
     *            Font path related to the assets folder (e.g. "fonts/YourFontName.ttf").
     */
    public static void applyFont(final Context context, final View root, final String fontName) {
        try {
            if (root instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) root;
                for (int i = 0; i < viewGroup.getChildCount(); i++)
                    applyFont(context, viewGroup.getChildAt(i), fontName);
            } else if (root instanceof TextView)
                ((TextView) root).setTypeface(Typeface.createFromAsset(context.getAssets(), fontName));
        } catch (Exception e) {
            Log.e(TAG, String.format("Error occured when trying to apply %s font for %s view", fontName, root));
            e.printStackTrace();
        }
    }

    public static void applyFont(final Context context, final TextView root) {
        try {
                root.setTypeface(Typeface.createFromAsset(context.getAssets(), Constants.ICONFONT_NAME));
        } catch (Exception e) {
            Log.e(TAG, String.format("Error occured when trying to apply %s font for %s view", Constants.ICONFONT_NAME, root));
            e.printStackTrace();
        }
    }
}
