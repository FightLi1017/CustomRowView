package lcx.viewstudy.Rowview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by lichenxi on 2017/3/17.
 */

public abstract class BaseGroupView extends LinearLayout {
    protected View line=null;
    protected ArrayList<BaseRowType> mRowTypes;
    protected OnRowCilickListener onRowCilickListener;
    public BaseGroupView(Context context) {
        super(context);
    }

    public BaseGroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseGroupView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public abstract void InitData(BaseGroupType GroupTypes,OnRowCilickListener onRowCilickListener);


    public abstract void NotifyChangeData();
    protected boolean isInvalid() {
        return null!=mRowTypes&&mRowTypes.size()>0;
    }
}
