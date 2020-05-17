package com.example.kamvardinaexpress;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class KhabargozariAdapter extends RecyclerView.Adapter<ghanonAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<khabargozari> imageModelArrayList;
    private Context mContext;
    @NonNull
    @Override
    public ghanonAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.recycler_khabargozari, viewGroup, false);
        ghanonAdapter.MyViewHolder holder = new ghanonAdapter.MyViewHolder(view);

        return holder;
    }

    public KhabargozariAdapter(Context mContext, ArrayList<khabargozari> imageModelArrayList) {
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
        this.imageModelArrayList = imageModelArrayList;
    }

    @Override
    public void onBindViewHolder(@NonNull ghanonAdapter.MyViewHolder myViewHolder, final int i) {
        myViewHolder.iv.setImageResource(imageModelArrayList.get(i).getImage_drawable());

        myViewHolder.time.setText(imageModelArrayList.get(i).getName());

        myViewHolder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (i){
                    case 0:
                        Intent intent = new Intent(mContext,KamvarDinaActivity.class);
                        mContext.startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(mContext,MizansiteActivity.class);
                        mContext.startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(mContext,ISNA_Activity.class);
                        mContext.startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(mContext,Farse_Activity.class);
                        mContext.startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(mContext,TabnakActivity.class);
                        mContext.startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(mContext,pressTvActivity.class);
                        mContext.startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(mContext,NavadActivity.class);
                        mContext.startActivity(intent6);
                        break;

                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnail;
        TextView time;
        ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);

            time =  itemView.findViewById(R.id.tv);
            iv =  itemView.findViewById(R.id.iv);
        }
    }
}
