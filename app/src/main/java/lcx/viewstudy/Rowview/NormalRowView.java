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

/**
 * Created by lichenxi on 2017/3/8.
 */

public class NormalRowView extends BaseRowView implements View.OnClickListener {
    private Context mContext;
    private ImageView mImageView;
    private TextView mTextView;
    private ImageButton mArrow;
    OnRowCilickListener mOnClickListener;
    private NormalRowType rowType;
    public NormalRowView(Context context) {
        super(context);
        this.mContext=context;
        Init();
    }

    public NormalRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext=context;
        Init();
    }

    public NormalRowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext=context;
        Init();
    }
    private void Init() {
        LayoutInflater.from(mContext).inflate(R.layout.row_view,this);
        mImageView=(ImageView)findViewById(R.id.MyImageView);
        mTextView=(TextView)findViewById(R.id.MyTextView);
        mArrow=(ImageButton)findViewById(R.id.arrow);
        mTextView.setText("set post");
        mImageView.setImageResource(R.drawable.user_info);
    }


    @Override
    public void InitData(BaseRowType rowType, OnRowCilickListener OnClickListener) {
        this.rowType=(NormalRowType) rowType;
        this.mOnClickListener=OnClickListener;
    }

    public void NotifyChangeData(){
        mImageView.setImageResource(rowType.resid);
        mTextView.setText(rowType.title);
        if (rowType.mRowAction!=null){
            setOnClickListener(this);
            setBackgroundResource(R.drawable.rowselector);
            mArrow.setVisibility(VISIBLE);
        }else{
            mArrow.setVisibility(GONE);
            setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public void onClick(View v) {
        mOnClickListener.onrowClick(rowType.mRowAction);
    }
}
