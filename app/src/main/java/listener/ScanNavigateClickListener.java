package listener;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.nyameh.kmitlnavi.MapsActivity;
import com.nyameh.kmitlnavi.NyaMehDatabase;

public class ScanNavigateClickListener implements View.OnClickListener {
    Context context;
    String placeCode;
    Dialog qrPassDialog;

    public ScanNavigateClickListener(Context context, String placeCode, Dialog qrPassDialog){
        this.context  = context;
        this.placeCode = placeCode;
        this.qrPassDialog = qrPassDialog;
    }

    @Override
    public void onClick(View view) {
        NyaMehDatabase mHelper = new NyaMehDatabase(context);
        SQLiteDatabase mDb = mHelper.getReadableDatabase();
        Cursor mCursor = mDb.rawQuery(String.format("SELECT * FROM " + NyaMehDatabase.TABLE_NAME)
                + " WHERE " + NyaMehDatabase.COL_CODE + "='" + placeCode + "'", null);
        mCursor.moveToFirst();

        Intent intent = new Intent(context, MapsActivity.class);
        intent.putExtra("Lat", Double.parseDouble(mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_LATITUDE))));
        intent.putExtra("Lng", Double.parseDouble(mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_LONGITUDE))));
        context.startActivity(intent);
        qrPassDialog.dismiss();
    }
}
