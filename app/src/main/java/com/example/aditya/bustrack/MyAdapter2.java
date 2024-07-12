package com.example.aditya.bustrack;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder2> {

    private ShowFeedback feedback;
    private List<Model2> mList;

    public MyAdapter2(ShowFeedback feedback, List<Model2> mList){
        this.feedback=feedback;
        this.mList=mList;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(feedback).inflate(R.layout.item2,parent,false);
        return new MyViewHolder2(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        holder.type.setText(mList.get(position).getType());
        holder.mob.setText(mList.get(position).getMob());
        holder.veh.setText(mList.get(position).getVeh());
        holder.dt.setText(mList.get(position).getDate());
        holder.feed.setText(mList.get(position).getFeed());
        holder.desc.setText(mList.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder{

        TextView type,mob,veh,dt,feed,desc;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);

            type=itemView.findViewById(R.id.tv1);
            mob=itemView.findViewById(R.id.tv2);
            veh=itemView.findViewById(R.id.tv3);
            dt=itemView.findViewById(R.id.tv4);
            feed=itemView.findViewById(R.id.tv5);
            desc=itemView.findViewById(R.id.tv6);
        }
    }
}
