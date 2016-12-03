package com.nyameh.kmitlnavi;

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

public class EventFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.events_fragment_layout, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.event_recycler_view);

        ArrayList<EventData> eventListData = new ArrayList<>();
        eventListData.add(new EventData("firstheader", "desdciptdsiontion", "FEB", "29"));
        eventListData.add(new EventData("LooooooooooongHeader", "thisissdeescripfrtionmmnag]e,,wbtdtnehtey" +
                "74k89.8.wevr2revtg53nu7i,o86,fv0[e0[qrvhu93pgtybw[neidvnier[0geqjrq[ghh3h000nyymy" +
                "mdraefwrwto8746l8;69l52rtrg5lghjajaja", "AUG", "20"));
        eventListData.add(new EventData("rgtyuio", "ykuyiluo;ulytr", "APR", "01"));
        eventListData.add(new EventData("งานลาดถิ่นพระจอม", "ที่ไหนหมือไร่ย่างไหร", "JAN", "03"));
        eventListData.add(new EventData("วันส่ง SE Project!", "โรงเชือด", "NOV", "06"));
        eventListData.add(new EventData("สอบ", "าิเืำะรบพต-ภะตุภ้่ำอนดาำ่ไำลขเ่ล-", "JUL", "31"));
        eventListData.add(new EventData("โลเร็ม", "ipsum dolor sit amet-", "SEP", "15"));

        DataListRecyclerAdapter adapter = new DataListRecyclerAdapter(eventListData, getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        return view;
    }
}
