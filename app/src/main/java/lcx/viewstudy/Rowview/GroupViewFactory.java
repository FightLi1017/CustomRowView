package lcx.viewstudy.Rowview;

import android.content.Context;

/**
 * Created by lichenxi on 2017/3/9.
 */

public class GroupViewFactory {

    public static BaseGroupView createGroupView(BaseGroupType groupType, Context context){
         if (groupType instanceof GroupType){
             return new GroupView(context);
         }
        if (groupType instanceof HeadGroupType){
            return new HeadExpandGroupView(context);
        }
        return null;
    }
}
