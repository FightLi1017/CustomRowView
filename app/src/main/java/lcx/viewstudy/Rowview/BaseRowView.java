package lcx.viewstudy.Rowview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by lichenxi on 2017/3/9.
 */

public abstract class BaseRowView extends LinearLayout {
    public BaseRowView(Context context) {
        super(context);
    }

    public BaseRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseRowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public abstract void InitData(BaseRowType mTypeList, OnRowCilickListener OnClickListener);
    public abstract void NotifyChangeData();
}
