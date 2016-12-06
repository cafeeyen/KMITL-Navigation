package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nyameh.kmitlnavi.MapsActivity;
import com.nyameh.kmitlnavi.NyaMehDatabase;
import com.nyameh.kmitlnavi.R;

import java.util.ArrayList;

import model.EventData;
import model.PlaceData;
import view.EventListViewHolder;
import view.PlaceListViewHolder;


public class PlaceListRecyclerAdapter extends RecyclerView.Adapter<PlaceListViewHolder> {

    Context context;
    LayoutInflater inflater;
    ArrayList<PlaceData> placeListData;
    RecyclerView mRecyclerView;

    public PlaceListRecyclerAdapter(ArrayList<PlaceData> placeListData, Context context) {
        this.placeListData = placeListData;
        this.context = context;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }

    @Override
    public PlaceListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.place_viewholder_row, parent, false);

        PlaceListViewHolder viewHolder = new PlaceListViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PlaceListViewHolder holder, int position) {
        final PlaceData placeData = placeListData.get(position);
        holder.tv1_header.setText(placeData.getName());
        holder.tv2_descrpt.setText(placeData.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MapsActivity.class);
                intent.putExtra("Lat", Double.parseDouble(placeData.getLatitude()));
                intent.putExtra("Lng", Double.parseDouble(placeData.getLongtitude()));
                intent.putExtra("title", placeData.getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return placeListData.size();
    }
}
