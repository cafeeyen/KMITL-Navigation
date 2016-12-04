package com.nyameh.kmitlnavi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import adapter.DataListRecyclerAdapter;
import model.EventData;

public class NewsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.news_fragment_layout, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.news_recycler_view);

        NyaMehDatabase mHelper = new NyaMehDatabase(getActivity());
        SQLiteDatabase mDb = mHelper.getReadableDatabase();
        Cursor mCursor = mDb.rawQuery(String.format("SELECT * FROM " + NyaMehDatabase.TABLE_NAME2) + " ORDER BY " + NyaMehDatabase.COL_DATE + " DESC", null);
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
                                        mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_DATE)).substring(6, 8),
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
            case "01": return "JAN";
            case "02": return "FEB";
            case "03": return "MAR";
            case "04": return "APR";
            case "05": return "MAY";
            case "06": return "JUN";
            case "07": return "JUL";
            case "08": return "AUG";
            case "09": return "SEP";
            case "10": return "OCT";
            case "11": return "NOV";
            case "12": return "DEC";
        }
        return "";
    }
}
