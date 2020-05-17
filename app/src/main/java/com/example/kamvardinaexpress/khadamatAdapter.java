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

public class khadamatAdapter extends RecyclerView.Adapter<khadamatAdapter.myViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<khadamat> imageModelArrayList;
    private Context mContext;
    @NonNull
    @Override
    public khadamatAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.khadamat, viewGroup, false);
        khadamatAdapter.myViewHolder holder = new khadamatAdapter.myViewHolder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull khadamatAdapter.myViewHolder myViewHolder, final int i) {
     //   myViewHolder.iv.setImageResource(imageModelArrayList.get(i).getImage_drawable());

        myViewHolder.time.setText(imageModelArrayList.get(i).getName());

        myViewHolder.time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (i){
                    case 0:
                        Intent intent = new Intent(mContext, sana_site_etelaa_rasani_ashkhas.class);
                        mContext.startActivity(intent);
                        break;

                }
            }
        });

    }

    public khadamatAdapter(Context mContext, ArrayList<khadamat> imageModelArrayList) {
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
        this.imageModelArrayList = imageModelArrayList;
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnail;
        TextView time;
        ImageView iv;

        public myViewHolder(View itemView) {
            super(itemView);

            time =  itemView.findViewById(R.id.tv2);
        //    iv =  itemView.findViewById(R.id.iv);
        }
    }



}
