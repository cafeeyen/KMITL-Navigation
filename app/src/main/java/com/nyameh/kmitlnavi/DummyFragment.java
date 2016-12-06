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
import adapter.PlaceListRecyclerAdapter;
import model.EventData;
import model.PlaceData;

public class DummyFragment extends Fragment {

    private static ArrayList<PlaceData> placeListData;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dummy, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.place_recycler_view);

        NyaMehDatabase mHelper = new NyaMehDatabase(getActivity());
        SQLiteDatabase mDb = mHelper.getReadableDatabase();

        Cursor mCursor = mDb.rawQuery("SELECT * FROM " + NyaMehDatabase.TABLE_NAME + " ORDER BY " + NyaMehDatabase.COL_NAME, null);
        mCursor.moveToFirst();

        placeListData = new ArrayList<>();

        while(!mCursor.isAfterLast())
        {
            placeListData.add
                    (
                            new PlaceData
                                    (
                                            mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_NAME)),
                                            mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_DESCRIPTION)),
                                            mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_LATITUDE)),
                                            mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_LONGITUDE))
                                    )
                    );
            mCursor.moveToNext();
        }

        PlaceListRecyclerAdapter adapter = new PlaceListRecyclerAdapter(placeListData, getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        return view;

    }

}
