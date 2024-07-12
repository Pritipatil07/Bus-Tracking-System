package com.example.aditya.bustrack;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ShowHelpdesk activity;
    private List<Model1> mList;

    public MyAdapter(ShowHelpdesk activity, List<Model1> mList){
        this.activity=activity;
        this.mList=mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item1,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText("Name: "+mList.get(position).getName());
        holder.email.setText("Email ID: "+mList.get(position).getEmail());
        holder.mob.setText("Mobile number: "+mList.get(position).getMob());
        holder.addr.setText("Address: "+mList.get(position).getAddr());
        holder.sub.setText("Subject: "+mList.get(position).getSub());
        holder.comp.setText("Complaint: "+mList.get(position).getComp());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,email,mob,addr,sub,comp;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.tv1);
            email=itemView.findViewById(R.id.tv2);
            mob=itemView.findViewById(R.id.tv3);
            addr=itemView.findViewById(R.id.tv4);
            sub=itemView.findViewById(R.id.tv5);
            comp=itemView.findViewById(R.id.tv6);

        }
    }
}
