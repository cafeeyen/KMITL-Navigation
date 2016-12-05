package listener;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Toast;

import com.nyameh.kmitlnavi.FavoriteFragment;
import com.nyameh.kmitlnavi.NyaMehDatabase;

import model.EventData;

public class LongRecyclerListListener implements View.OnLongClickListener {

    Context context;
    EventData eventData;
    String tabName;

    public LongRecyclerListListener(Context context, EventData eventData, String tabName) {
        this.context = context;
        this.eventData = eventData;
        this.tabName = tabName;
    }

    @Override
    public boolean onLongClick(View view) {
        NyaMehDatabase mHelper = new NyaMehDatabase(context.getApplicationContext());
        SQLiteDatabase mDb = mHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        if(tabName.equals("Favorite")){
            values.put(NyaMehDatabase.COL_FAVORITE, "false");
            Toast.makeText(context, "Deleted from Favorite ", Toast.LENGTH_SHORT).show();
        }
        else if(tabName.equals("News")){
            values.put(NyaMehDatabase.COL_FAVORITE, "true");
            Toast.makeText(context, "Add to Favorite Success", Toast.LENGTH_SHORT).show();
        }
        mDb.update(NyaMehDatabase.TABLE_NAME2, values, NyaMehDatabase.COL_TITLE + " = ?", new String[]{String.valueOf(eventData.getHeader())});
        Cursor mCursor = mDb.rawQuery("SELECT * FROM " + NyaMehDatabase.TABLE_NAME2
                + " WHERE " + NyaMehDatabase.COL_TITLE + " = '" + eventData.getHeader() + "'", null);
        mCursor.moveToFirst();

        return false;
    }
}
