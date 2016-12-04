package listener;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nyameh.kmitlnavi.R;

import model.EventData;
import view.EventListViewHolder;

public class DataRecyclererListListener implements View.OnClickListener {

    Context context;
    EventData evdata;

    public DataRecyclererListListener(Context context, EventData evdata){
        this.context = context;
        this.evdata = evdata;
    }

    @Override
    public void onClick(View view) {
        EventListViewHolder vholder = (EventListViewHolder) view.getTag();
        int position = vholder.getPosition();
        final Dialog dialog = new Dialog(context);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(R.layout.description_dialogbox_layout);
        dialog.setTitle("Position" + position);
        dialog.setCancelable(true);
        TextView header =(TextView)dialog.findViewById(R.id.des_header);
        TextView data = (TextView)dialog.findViewById(R.id.des_data);
        TextView date = (TextView)dialog.findViewById(R.id.des_date);
        header.setText(evdata.getHeader());
        data.setText("Description: \n" + evdata.getDescrpt());
        date.setText("Date: " + evdata.getDate() + " " + evdata.getMonth());
        Button closeButton = (Button)dialog.findViewById(R.id.close_dialog_button);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }
}
