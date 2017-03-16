package lcx.viewstudy.Rowview;

/**
 * Created by lichenxi on 2017/3/8.
 */

public class NormalRowType extends BaseRowType {
     public int resid;
     public NormalRowType(int resid, String title, RowAction rowAction) {
        super(rowAction,title);
       this.resid=resid;
    }
}
