package view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nyameh.kmitlnavi.R;

public class PlaceListViewHolder extends RecyclerView.ViewHolder {
    public TextView tv1_header, tv2_descrpt;

    public PlaceListViewHolder(View itemView) {
        super(itemView);
        tv1_header = (TextView) itemView.findViewById(R.id.place_name);
        tv2_descrpt = (TextView) itemView.findViewById(R.id.place_desc);
    }
}


