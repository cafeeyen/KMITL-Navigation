package com.nyameh.kmitlnavi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import adapter.DataListRecyclerAdapter;
import model.EventData;

public class FavoriteFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.events_fragment_layout, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.event_recycler_view);

        NyaMehDatabase mHelper = new NyaMehDatabase(getActivity());
        SQLiteDatabase mDb = mHelper.getReadableDatabase();
        //================= Query Here ==================
        Cursor mCursor = mDb.rawQuery("SELECT * FROM " + NyaMehDatabase.TABLE_NAME2
                + " WHERE " + NyaMehDatabase.COL_FAVORITE + " ='true'", null);
        mCursor.moveToFirst();

        ArrayList<EventData> eventListData = new ArrayList<>();

        while(!mCursor.isAfterLast())
        {
            eventListData.add
                    (
                            new EventData
                                    (
                                            mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_TITLE)),
                                            mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_CONTENT)),
                                            monthText(mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_DATE)).substring(3, 5)),
                                            NyaMehDatabase.COL_ID + mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_ID)),
                                            mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_POSITION))
                                    )
                    );
            mCursor.moveToNext();
        }

        DataListRecyclerAdapter adapter = new DataListRecyclerAdapter(eventListData, getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        return view;
    }

    private String monthText(String month)
    {
        switch(month)
        {
            case "1": return "JAN";
            case "2": return "FEB";
            case "3": return "MAR";
            case "4": return "APR";
            case "5": return "MAY";
            case "6": return "JUN";
            case "7": return "JUL";
            case "8": return "AUG";
            case "9": return "SEP";
            case "10": return "OCT";
            case "11": return "NOV";
            case "12": return "DEC";
        }
        return "";
    }
}
