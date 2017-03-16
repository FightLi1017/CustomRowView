package lcx.viewstudy.Rowview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import lcx.viewstudy.R;

/**
 * Created by lichenxi on 2017/3/8.
 */

public class GroupView extends LinearLayout {
    private ArrayList<BaseRowType> mRowTypes;
    private Context mcontext;
    private String title;
   private BaseRowView rowview=null;
   private View line=null;
   private RowViewFactory rowViewFactory=null;
   private BaseRowType rowType;
   private OnRowCilickListener onRowCilickListener;
    public GroupView(Context context) {
        super(context);
        Init(context);
    }

    public GroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Init(context);
    }

    public GroupView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Init(context);
    }
    private void Init(Context context) {
        this.mcontext=context;
        setOrientation(VERTICAL);
        //一般我们可以在这里加上一个title么
//       LayoutInflater.from(context).inflate()
    }
   public void InitData(GroupType GroupTypes,OnRowCilickListener onRowCilickListener)
   {     this.onRowCilickListener=onRowCilickListener;
         this.mRowTypes=GroupTypes.mRowTypes;
         this.title=GroupTypes.title;
         rowViewFactory=new RowViewFactory();
   }
    public void NotifyChangeData(){
        if (null!=mRowTypes&&mRowTypes.size()>0){
              LayoutParams layoutParams=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,1);
              layoutParams.leftMargin=30;
              layoutParams.rightMargin=30;
              for (int i=0;i<mRowTypes.size();i++){
                  rowview=rowViewFactory.createRowView(mRowTypes.get(i),mcontext);
                  rowview.InitData(mRowTypes.get(i),onRowCilickListener);
                  rowview.NotifyChangeData();
                  addView(rowview);
                  if (i!=mRowTypes.size()-1){
                     line=new View(mcontext);
                     line.setBackgroundColor(getResources().getColor(R.color.grey_200));
                     addView(line,layoutParams);
                }
            }

        }else{
            setVisibility(GONE);
        }
    }
}
