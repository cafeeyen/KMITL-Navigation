package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nyameh.kmitlnavi.R;

import java.util.ArrayList;

import listener.ClickRecyclerListListener;
import listener.LongRecyclerListListener;
import model.EventData;
import view.EventListViewHolder;


public class DataListRecyclerAdapter extends RecyclerView.Adapter<EventListViewHolder> {

    Context context;
    LayoutInflater inflater;
    ArrayList<EventData> eventListData;
    RecyclerView mRecyclerView;
    String tabName;

    public DataListRecyclerAdapter(ArrayList<EventData> eventListData, Context context, String tabName) {
        this.eventListData = eventListData;
        this.context = context;
        this.tabName = tabName;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }

    @Override
    public EventListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.list_viewholder_row, parent, false);

        EventListViewHolder viewHolder = new EventListViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final EventListViewHolder holder, int position) {
        EventData evdata = eventListData.get(position);
        holder.tv1_header.setText(evdata.getHeader());
        holder.tv2_descrpt.setText(evdata.getDescrpt());
        holder.tv3_month.setText(evdata.getMonth());
        holder.tv4_date.setText(evdata.getDate());
        holder.itemView.setOnClickListener(new ClickRecyclerListListener(context, evdata));
        holder.itemView.setOnLongClickListener(new LongRecyclerListListener(context, evdata, tabName));
        holder.itemView.setTag(holder);
    }


    @Override
    public int getItemCount() {
        return eventListData.size();
    }
}
