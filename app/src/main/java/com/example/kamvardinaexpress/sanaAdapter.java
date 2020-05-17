package com.example.kamvardinaexpress;


import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class sanaAdapter extends RecyclerView.Adapter<sanaAdapter.MyViewHolder> {
    private Context mContext;
    private LayoutInflater inflater;
    private ArrayList<sana> imageModelArrayList;

    public sanaAdapter(Context mContext, ArrayList<sana> imageModelArrayList){
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
        this.imageModelArrayList = imageModelArrayList;
    }

    @Override
    public sanaAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recylerview_sana, parent, false);
        sanaAdapter.MyViewHolder holder = new sanaAdapter.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(sanaAdapter.MyViewHolder holder, final int position) {

        holder.iv.setImageResource(imageModelArrayList.get(position).getImage_drawable());
        holder.time.setText(imageModelArrayList.get(position).getName());

        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0 :
                        Intent intent = new Intent(mContext,Sana_site_Eblagh.class);
                        mContext.startActivity(intent);
                        break;
                    case 1 :
                        Intent intent1 = new Intent(mContext,Activity_sana_Vokala.class);
                        mContext.startActivity(intent1);
                        break;

                    case 2 :
                        Intent intent2 = new Intent(mContext,sana_site_etelaa_rasani_ashkhas.class);
                        mContext.startActivity(intent2);
                        break;
                    case 3 :
                        Intent intent3 = new Intent(mContext,Sana_site_Sabtname.class);
                        mContext.startActivity(intent3);
                        break;

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView time;
        ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);

            time = (TextView) itemView.findViewById(R.id.tv5);
            iv = (ImageView) itemView.findViewById(R.id.iv5);
        }
    }
}
