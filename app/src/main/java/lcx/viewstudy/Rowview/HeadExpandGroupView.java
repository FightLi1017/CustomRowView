package lcx.viewstudy.Rowview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import lcx.viewstudy.R;

/**
 * Created by lichenxi on 2017/3/17.
 */

public class HeadExpandGroupView extends BaseGroupView {
    private Context mcontext;
    private BaseRowView rowview=null;
    private RowViewFactory rowViewFactory=null;
    private LinearLayout TitleLayout;
    private LinearLayout RowLayout;
    private TextView mTitleView;
    private ImageButton arrow;
    private String title;
    int LayoutHeight;
    public HeadExpandGroupView(Context context) {
        super(context);
        Init(context);
    }
    public HeadExpandGroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Init(context);
    }

    public HeadExpandGroupView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Init(context);
    }
    private void Init(Context context) {
        this.mcontext=context;
        setOrientation(VERTICAL);
        LayoutInflater.from(context).inflate(R.layout.group_view,this);
        arrow=(ImageButton)findViewById(R.id.arrow);
        TitleLayout=(LinearLayout) findViewById(R.id.titleLayout);
        RowLayout=(LinearLayout) findViewById(R.id.rowLayout);
    }
    @Override
    public void InitData(BaseGroupType GroupTypes, OnRowCilickListener onRowCilickListener) {
        this.onRowCilickListener=onRowCilickListener;
        this.mRowTypes=GroupTypes.mRowTypes;
        this.title=GroupTypes.title;
        rowViewFactory=new RowViewFactory();
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        LayoutHeight=RowLayout.getHeight();
        RowLayout.setVisibility(GONE);
    }

    @Override
    public void NotifyChangeData() {
        if (isInvalid()){
             mTitleView=(TextView) findViewById(R.id.title);
             mTitleView.setText(title);
             TitleLayout.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (RowLayout.getVisibility()==View.GONE){
                        openAnim(RowLayout);
                        openArrow(arrow);
                    }else{
                        closeArrow(arrow);
                        closeAnim(RowLayout);
                    }
                }
            });
            LayoutParams layoutParams=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,1);
            layoutParams.leftMargin=30;
            layoutParams.rightMargin=30;
            for (int i=0;i<mRowTypes.size();i++){
                rowview=rowViewFactory.createRowView(mRowTypes.get(i),mcontext);
                rowview.InitData(mRowTypes.get(i),onRowCilickListener);
                rowview.NotifyChangeData();
                RowLayout.addView(rowview);
                if (i!=mRowTypes.size()-1){
                    line=new View(mcontext);
                    line.setBackgroundColor(getResources().getColor(R.color.grey_200));
                    RowLayout.addView(line,layoutParams);
                }
            }
        }else{
            setVisibility(GONE);
        }

    }

    private void closeArrow(View v) {
        ObjectAnimator
                .ofFloat(v, "rotation", 0.0F, 90.0F)
                .setDuration(500)
                .start();
    }

    private void openArrow(View v) {
        ObjectAnimator
                .ofFloat(v, "rotation", 0.0F, 90.0F)
                .setDuration(500)
                .start();
    }

    public void openAnim(View view ){
        RowLayout.setVisibility(View.VISIBLE);
        ValueAnimator valueAnimator=CreateAnim(view,0,LayoutHeight);
        valueAnimator.start();
    }
    public void closeAnim( final View view){
        int height= view.getHeight();
        ValueAnimator valueAnimator=CreateAnim(view,height,0);
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                view.setVisibility(View.GONE);
            }
        });
        valueAnimator.start();
    }

    public ValueAnimator CreateAnim(final View view,int start,int end){
        ValueAnimator valueAnimator=ValueAnimator.ofInt(start,end);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value=(int)animation.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams=view.getLayoutParams();
                layoutParams.height=value;
                view.setLayoutParams(layoutParams);
            }
        });
        return valueAnimator;
    }
}
