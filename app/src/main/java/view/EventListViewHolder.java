package view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.nyameh.kmitlnavi.R;


public class EventListViewHolder extends RecyclerView.ViewHolder {

    public TextView tv1_header, tv2_descrpt, tv3_month, tv4_date;
    public ImageView imageView;

    public EventListViewHolder(View itemView) {
        super(itemView);
/*        Typeface typeFace = Typeface.createFromAsset(itemView.getContext().getAssets(),"fonts/GILLUBCD.TTF");*/

        tv1_header = (TextView) itemView.findViewById(R.id.list_header);
        tv2_descrpt = (TextView) itemView.findViewById(R.id.list_desc);
        tv3_month = (TextView) itemView.findViewById(R.id.month);
        tv4_date = (TextView) itemView.findViewById(R.id.date);
        imageView= (ImageView) itemView.findViewById(R.id.list_date);

    }
}
