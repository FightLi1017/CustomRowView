package lcx.viewstudy.Rowview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import lcx.viewstudy.R;

public class MainActivity extends AppCompatActivity implements OnRowCilickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();
}

    private void InitView() {
        ContainerView containerView=(ContainerView)findViewById(R.id.rowview);
        ArrayList<BaseRowType> mlist=new ArrayList<>();
        ArrayList<BaseRowType> mlist1=new ArrayList<>();
        ArrayList<BaseRowType> mlist2=new ArrayList<>();
        ArrayList<BaseRowType> mlist3=new ArrayList<>();
        ArrayList<BaseRowType> mlist4=new ArrayList<>();
        ArrayList<GroupType> groupTypes=new ArrayList<>();
        mlist.add(new ProfileRowType(R.drawable.touxiang,"李晨希", RowAction.PROFILE));
        GroupType grouptype=new GroupType(mlist);
        groupTypes.add(grouptype);
        mlist1.add(new NormalRowType(R.drawable.user_share,"账户信息",RowAction.My_GET));
        mlist1.add(new NormalRowType(R.drawable.user_exit,"我的钱包",RowAction.My_HAND));
        GroupType grouptype1=new GroupType(mlist1);
        groupTypes.add(grouptype1);
        mlist2.add(new NormalRowType(R.drawable.user_change_phone,"更换手机", RowAction.My_SEETING));
        mlist2.add(new NormalRowType(R.drawable.user_change_pwd,"更换密码",RowAction.My_HAND));
        GroupType grouptype2=new GroupType(mlist2);
        groupTypes.add(grouptype2);
        mlist3.add(new NormalRowType(R.drawable.user_info,"我的保单", RowAction.My_SEETING));
        mlist3.add(new NormalRowType(R.drawable.user_update,"我要啪啪",RowAction.My_HAND));
        GroupType grouptype3=new GroupType(mlist3);
        groupTypes.add(grouptype3);
        mlist4.add(new NormalRowType(R.drawable.user_info,"关于我们", RowAction.My_SEETING));
        GroupType grouptype4=new GroupType(mlist4);
        groupTypes.add(grouptype4);
        containerView.InitData(groupTypes,this);
        containerView.NotifyChangeData();
    }


    @Override
    public void onrowClick(RowAction rowAction) {
        Toast.makeText(this,rowAction+"",Toast.LENGTH_SHORT).show();
    }
}