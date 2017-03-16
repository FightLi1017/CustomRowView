package lcx.viewstudy.Rowview;

import java.util.ArrayList;

import lcx.viewstudy.Rowview.BaseRowType;

/**
 * Created by lichenxi on 2017/3/9.
 */

public class GroupType {
  public ArrayList<BaseRowType>  mRowTypes;
  public String title;
    public GroupType(ArrayList<BaseRowType> rowTypes) {
        mRowTypes = rowTypes;
    }
    public GroupType(ArrayList<BaseRowType> rowTypes, String title) {
        mRowTypes = rowTypes;
        this.title = title;
    }
}
