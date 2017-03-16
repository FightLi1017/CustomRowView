package lcx.viewstudy.Rowview;

/**
 * Created by lichenxi on 2017/3/9.
 */

public class BaseRowType {
    //11111111sss
    public RowAction mRowAction;
    public String title;

    public BaseRowType(RowAction rowAction, String title) {
        mRowAction = rowAction;
        this.title = title;
    }
}
