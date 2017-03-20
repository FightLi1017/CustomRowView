package lcx.viewstudy.Rowview;

import java.util.ArrayList;

/**
 * Created by lichenxi on 2017/3/17.
 */

public class BaseGroupType {
    public ArrayList<BaseRowType> mRowTypes;
    public String title;
    public BaseGroupType(ArrayList<BaseRowType> rowTypes) {
        this(rowTypes,"");
    }
    public BaseGroupType(ArrayList<BaseRowType> rowTypes, String title) {
        mRowTypes = rowTypes;
        this.title = title;
    }
}
