package com.example.kamvardinaexpress;

import android.content.Context;
import android.content.Intent;

import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ghanonAdapter extends RecyclerView.Adapter<ghanonAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<ghanon> imageModelArrayList;
    private Context mContext;
    String LOG ="salam";

    private static final String TAG = "CHECK";
    static class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView thumbnail;
        TextView time;
        ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);

            time =  itemView.findViewById(R.id.tv);
            iv =  itemView.findViewById(R.id.iv);


        }
    }


    public ghanonAdapter(Context mContext, ArrayList<ghanon> imageModelArrayList){
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
        this.imageModelArrayList = imageModelArrayList;



    }


    @Override
    public ghanonAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recycler_ghanon, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
     //   Log.d(TAG,"سلام");

        return holder;
    }




    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    @Override
    public void onBindViewHolder(ghanonAdapter.MyViewHolder holder, final int position) {

       holder.iv.setImageResource(imageModelArrayList.get(position).getImage_drawable());

        holder.time.setText(imageModelArrayList.get(position).getName());


        // Glide.with(mContext).load(ghanon.getImage_drawable()).into(holder.thumbnail);


        //Glide.with(mContext).load(ghanon.getImage_drawable()).into(holder.getImage_drawable);
        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){

                    case 0:
                        Intent intent = new Intent(mContext,Ghanon_Assasi_Activity.class);
                        mContext.startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(mContext,HoghoghiActivity.class);
                        mContext.startActivity(intent1);
                        break;

                    case 2:
                        Intent intent2 = new Intent(mContext,jaza_Activity.class);
                        mContext.startActivity(intent2);
                        break;

                    case 3:
                        Intent intent3 = new Intent(mContext,Tegarat_Activity.class);
                        mContext.startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(mContext,GhaonoOmomiActivity.class);
                        mContext.startActivity(intent4);
                        break;
                    case 5 :
                        Intent intent5 = new Intent(mContext,Registry_law_Activity.class);
                        mContext.startActivity(intent5);
  //                      Toast.makeText(mContext, "در نسخه های بعدی اضافه خواهذ شد", Toast.LENGTH_SHORT).show();
                        break;
                    case 6 :
                        Intent intent6 = new Intent(mContext,lawyerLawAsli.class);
                        mContext.startActivity(intent6);
                        break;
                    case 7 :
                        Intent intent7 = new Intent(mContext,Family_law_Activity.class);
                        mContext.startActivity(intent7);
                        break;
                    case 8 :
                        Intent intent8 = new Intent(mContext,RouhaniActivity.class);
                        mContext.startActivity(intent8);
                }
            }
        });

    }


}
