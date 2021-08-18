package com.tara.basicregistrartion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterResponse extends RecyclerView.Adapter<AdapterResponse.ViewHolder> {
    Context context;
    List<Response> responseList = new ArrayList<>();
    public AdapterResponse( Context context,List<Response> responseList){
        this.context = context;
        this.responseList = responseList;
    }
    @NonNull
    @Override
    public AdapterResponse.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemlist_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterResponse.ViewHolder holder, int position) {
         Response response = responseList.get(position);
         holder.tv_id.setText(String.valueOf(response.getId()));
         holder.tv_postid.setText(String.valueOf(response.getPostId()));
         holder.tv_name.setText(response.getName());
         holder.tv_email.setText(response.getEmail());
         holder.tv_body.setText(response.getAnkur());
    }

    @Override
    public int getItemCount() {
        return responseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_id,tv_postid,tv_name,tv_email,tv_body;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_id = (TextView)itemView.findViewById(R.id.tv_id);
            tv_postid = (TextView)itemView.findViewById(R.id.tv_postid);
            tv_name = (TextView)itemView.findViewById(R.id.tv_name);
            tv_email = (TextView)itemView.findViewById(R.id.tv_email);
            tv_body = (TextView)itemView.findViewById(R.id.tv_body);
        }

    }
}
