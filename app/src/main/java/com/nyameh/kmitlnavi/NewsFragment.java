package com.nyameh.kmitlnavi;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_fragment_layout, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.news_recycler_view);

        ArrayList<EventData> eventListData = new ArrayList<>();
        eventListData.add(new EventData("first NeWS", "NEWSnewnsjnenwsnenwnsnwewesewe", "JAN", "29"));
        eventListData.add(new EventData("second news", "thisissdeescripfrtionmmnag]e,,wbtdtnehtey" +
                "74k89.8.wevr2revtg53nu7i,o86,fv0[e0[qrvhu93pgtybw[neidvnier[0geqjrq[ghh3h000nyymy" +
                "mdraefwrwto8746l8;69l52rtrg5lghjajaja", "SEP", "10"));
        eventListData.add(new EventData("วันส่ง SE Project!", "โรงเชือดคิมอ้วน", "NOV", "06"));
        eventListData.add(new EventData("โลเร็ม", "ipsum dolor sit amet-", "FEB", "31"));
        eventListData.add(new EventData("สอบ", "ตากยตายตายตาตายตายตายตายหายนกานานกนกนตายยนาย", "NOV", "29"));
        eventListData.add(new EventData("วันโกหก", "ออร์แกน อยุติธรรมผลไม้ เซอร์ไพรส์มาร์เก็ตติ้งซูม สแควร์คาร์เดบิตอินเตอร์จึ๊ก สงบสุข โอยัว" +
                "ะฟอยล์แจ๊กเก็ต แชมป์ไฟลต์สเตย์ ชนะเลิศเทรดออทิสติก ปิโตรเคมีดีไซน์เนอร์ออสซี่ เฉิ่มอพาร์ตเมนท์เพาเวอร์โปรดิวเซอร์ ล็อตไฮบริดแอลมอนด์ ซีดานคาสิโน " +
                "ริกเตอร์แอลมอนด์ บึมแพนงเชิญยากูซ่า ปาสคาลเที่ยงวันแซ็กหมายปอง เบลอ", "APR", "01"));
        eventListData.add(new EventData("งานลาดถิ่นพระจอม", "ที่ไหนหมือไร่ย่างไหร", "JAN", "03"));
        eventListData.add(new EventData("งานไรไม่รู้", "รันเวย์ธรรมาภิบาลสต๊อกคอร์ปคอนโทรล ฮาโลวีนสกรัมสะกอมแซ็กโซโฟนออทิสติก จิ๊กโก๋สตรอ" +
                "เบอรีเทวาจิตเภทซาร์ดีน แจม แบล็คนรีแพทย์คอมเพล็กซ์ มาม่าสโรชาคอปเตอร์เก๊ะคอมเพล็กซ์ ดาวน์เมาท์ แมนชั่นน้องใหม่เมาท์ฮองเฮา พาร์กีวีโอเพ่น เรซิ่น ปา" +
                "สคาลเอาต์แมกกาซีนสต๊อก น็อกโรลออนเพาเวอร์ พลาซ่าเฟอร์รี่นายพราน เซอร์ไพรส์ลิมูซีนมหภาคอวอร์ด เอฟเฟ็กต์วอลล์เสือโคร่งแซนด์วิช มาร์ชกรุ๊ปแรงใจวีซ่า" +
                "ซีนีเพล็กซ์เซ็นทรัลซิมโฟนีช็อปเปอร์ แฟนซีบ๊วยพันธกิจ สมิติเวชวีไอพีไตรมาส เมคอัพสุริยยาตรเยอบีร่าวาไรตี้วาไรตี้ โฮปร็อคอาร์พีจีคาสิโน ว้อยช็อปปิ้ง " +
                "สไลด์ถูกต้องบอร์ด ฟีเวอร์ ยาวีแบตไทม์นาฏยศาลาบาร์บี้ ฟินิกซ์อ่อนด้อยพุทโธซูเอี๋ยสามแยก ลิสต์ ศากยบุตรโปรเจคท์ซากุระ ดัมพ์บาลานซ์วานิลาโค้ก " +
                "เจ๊าะแจ๊ะเก๋ากี้ปูอัดสุริยยาตร์ ฟิวเจอร์ลิมิตเอ็นจีโอ เปปเปอร์มินต์พริตตี้", "JAN", "03"));

        DataListRecyclerAdapter adapter = new DataListRecyclerAdapter(eventListData, getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        return view;
        /*return inflater.inflate(R.layout.news_fragment_layout,null);*/
    }


}
