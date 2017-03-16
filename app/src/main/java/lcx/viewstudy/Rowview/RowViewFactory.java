package lcx.viewstudy.Rowview;

import android.content.Context;

import lcx.viewstudy.Rowview.BaseRowType;
import lcx.viewstudy.Rowview.BaseRowView;
import lcx.viewstudy.Rowview.NormalRowType;
import lcx.viewstudy.Rowview.NormalRowView;
import lcx.viewstudy.Rowview.ProfileRowType;
import lcx.viewstudy.Rowview.ProfileRowView;

/**
 * Created by lichenxi on 2017/3/9.
 */

public class RowViewFactory {

    public BaseRowView createRowView(BaseRowType rowType, Context context){
         if (rowType instanceof NormalRowType){
             return new NormalRowView(context);
         }
        if (rowType instanceof ProfileRowType){
            return new ProfileRowView(context);
        }
        return null;
    }
}
