package listener;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.nyameh.kmitlnavi.MapsActivity;
import com.nyameh.kmitlnavi.NyaMehDatabase;
import com.nyameh.kmitlnavi.R;

import model.EventData;

public class DataRecyclererListListener implements View.OnClickListener {

    Context context;
    EventData evdata;

    public DataRecyclererListListener(Context context, EventData evdata){
        this.context = context;
        this.evdata = evdata;
    }

    @Override
    public void onClick(View view) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(R.layout.description_dialogbox_layout);
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

        Button navigateButton = (Button)dialog.findViewById(R.id.route_dialog_button) ;
        navigateButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                NyaMehDatabase mHelper = new NyaMehDatabase(context.getApplicationContext());
                SQLiteDatabase mDb = mHelper.getReadableDatabase();
                Cursor mCursor = mDb.rawQuery(String.format("SELECT * FROM " + NyaMehDatabase.TABLE_NAME)
                        + " WHERE " + NyaMehDatabase.COL_CODE + "='" + evdata.getPosition() + "'", null);
                mCursor.moveToFirst();
                Intent intent = new Intent(context, MapsActivity.class);
                intent.putExtra("Lat", Double.parseDouble(mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_LATITUDE))));
                intent.putExtra("Lng", Double.parseDouble(mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_LONGITUDE))));
                context.startActivity(intent);
            }
        });
        dialog.show();

    }
}
