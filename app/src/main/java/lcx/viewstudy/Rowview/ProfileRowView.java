package lcx.viewstudy.Rowview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import lcx.viewstudy.R;
import lcx.viewstudy.Rowview.BaseRowType;
import lcx.viewstudy.Rowview.BaseRowView;
import lcx.viewstudy.Rowview.OnRowCilickListener;
import lcx.viewstudy.Rowview.ProfileRowType;

/**
 * Created by lichenxi on 2017/3/8.
 */

public class ProfileRowView extends BaseRowView implements View.OnClickListener {
    private Context mContext;
    private ImageView mImageView;
    private TextView mTextView;
    private ImageButton mArrow;
    OnRowCilickListener mOnClickListener;
    private ProfileRowType rowType;
    public ProfileRowView(Context context) {
        super(context);
        this.mContext=context;
        Init();
    }

    public ProfileRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext=context;
        Init();
    }

    public ProfileRowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext=context;
        Init();
    }
    private void Init() {
        LayoutInflater.from(mContext).inflate(R.layout.profilerow_view,this);
        mImageView=(ImageView)findViewById(R.id.ImgProfile);
        mTextView=(TextView)findViewById(R.id.profileName);
        mTextView.setText("");
    }


    @Override
    public void InitData(BaseRowType rowType, OnRowCilickListener OnClickListener) {
        this.rowType=(ProfileRowType) rowType;
        this.mOnClickListener=OnClickListener;
    }

    public void NotifyChangeData(){
        mImageView.setImageResource(rowType.resid);
        mTextView.setText(rowType.title);
        if (rowType.mRowAction!=null){
            setOnClickListener(this);
            setBackgroundResource(R.drawable.rowselector);
        }else{
            setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public void onClick(View v) {
        mOnClickListener.onrowClick(rowType.mRowAction);
    }
}
