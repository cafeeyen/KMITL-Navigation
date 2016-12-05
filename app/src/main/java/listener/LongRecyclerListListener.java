package listener;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Toast;

import com.nyameh.kmitlnavi.NyaMehDatabase;

import model.EventData;

public class LongRecyclerListListener implements View.OnLongClickListener {

    Context context;
    EventData eventData;

    public LongRecyclerListListener(Context context, EventData eventData) {
        this.context = context;
        this.eventData = eventData;
    }

    @Override
    public boolean onLongClick(View view) {
        NyaMehDatabase mHelper = new NyaMehDatabase(context.getApplicationContext());
        SQLiteDatabase mDb = mHelper.getReadableDatabase();
        mDb.rawQuery("update " + NyaMehDatabase.TABLE_NAME2 + " set "+ NyaMehDatabase.COL_FAVORITE + "= 'true'" +
                " where " + NyaMehDatabase.COL_TITLE + "='" + eventData.getHeader() + "'",null);
        Toast.makeText(context, "Add to Favorite Success", Toast.LENGTH_SHORT).show();
        return false;
    }
}
