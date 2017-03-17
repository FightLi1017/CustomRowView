package lcx.viewstudy.Rowview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by lichenxi on 2017/3/9.
 */

public class ContainerView extends LinearLayout {
   private ArrayList<BaseGroupType> mGroupTypes;
    private Context mcontext;
    private OnRowCilickListener onRowCilickListener;
    private BaseGroupView groupView=null;
    public ContainerView(Context context) {
        super(context);
        Init(context);
    }

    public ContainerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Init(context);
    }

    public ContainerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Init(context);
    }
    private void Init(Context context) {
        this.mcontext=context;
        setOrientation(VERTICAL);
    }
    public void InitData(ArrayList<BaseGroupType> mGroupTypes, OnRowCilickListener onRowCilickListener){
       this.mGroupTypes=mGroupTypes;
        this.onRowCilickListener=onRowCilickListener;
    }
    public void NotifyChangeData(){
         if (null!=mGroupTypes&&mGroupTypes.size()>0){
             float density=mcontext.getResources().getDisplayMetrics().density;
             LayoutParams layoutParams=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
             layoutParams.topMargin=(int)(10*density);
             for (int i=0;i<mGroupTypes.size();i++){
                 groupView=GroupViewFactory.createGroupView(mGroupTypes.get(i),mcontext);
                 groupView.InitData(mGroupTypes.get(i),onRowCilickListener);
                 groupView.NotifyChangeData();
                 if (i!=0){
                     addView(groupView,layoutParams);
                 }else{
                     addView(groupView);
                 }

             }

         }
    }
}
