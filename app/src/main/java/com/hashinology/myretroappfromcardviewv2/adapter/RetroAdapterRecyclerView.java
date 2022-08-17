package com.hashinology.myretroappfromcardviewv2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hashinology.myretroappfromcardviewv2.R;
import com.hashinology.myretroappfromcardviewv2.model.ModelData;
import com.hashinology.myretroappfromcardviewv2.ui.InterfaceAdapter;

import java.util.List;

public class RetroAdapterRecyclerView extends RecyclerView.Adapter<RetroAdapterRecyclerView.MyView> {
    private List<ModelData> mList;
    private LayoutInflater mInflater;
    private InterfaceAdapter interfaceAdapter;

    public RetroAdapterRecyclerView(List<ModelData> mList, Context context) {
        this.mList = mList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.retrofit_list, parent, false);
        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        ModelData data = mList.get(position);
        holder.tvUserId.setText(String.valueOf(data.getUserId()));
        holder.tvId.setText(String.valueOf(data.getId()));
        holder.tvTtile.setText(data.getTitle());
        holder.tvBody.setText(data.getBody());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyView extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvUserId, tvId, tvTtile, tvBody;
        public MyView(@NonNull View itemView) {
            super(itemView);
            tvUserId = itemView.findViewById(R.id.tvUserId);
            tvId = itemView.findViewById(R.id.tvID);
            tvTtile = itemView.findViewById(R.id.tvTitle);
            tvBody = itemView.findViewById(R.id.tvBody);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (interfaceAdapter != null){
                interfaceAdapter.myInterfaceClcicked(view, getAdapterPosition());
            }
        }
    }

    public void getAdapterInterface(InterfaceAdapter interfaceAdapter){
        this.interfaceAdapter = interfaceAdapter;
    }
}
