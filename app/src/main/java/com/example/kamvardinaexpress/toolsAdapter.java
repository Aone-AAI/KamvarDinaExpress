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

public class toolsAdapter extends RecyclerView.Adapter<toolsAdapter.myViewholder> {

    private Context mContext;
    private LayoutInflater inflater;
    private ArrayList<tools> imageModelArrayList;

    public toolsAdapter(Context mContext, ArrayList<tools> imageModelArrayList){
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
        this.imageModelArrayList = imageModelArrayList;
    }
    @NonNull
    @Override
    public toolsAdapter.myViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = inflater.inflate(R.layout.recycler_tools, viewGroup, false);
        toolsAdapter.myViewholder holder = new toolsAdapter.myViewholder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull toolsAdapter.myViewholder myViewholder,final int i) {
        myViewholder.iv.setImageResource(imageModelArrayList.get(i).getImage_drawable());
        myViewholder.time.setText(imageModelArrayList.get(i).getName());

        myViewholder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (i){
                    case 0 :
                        Intent intent = new Intent(mContext,QuestionsMotedavel.class);
                        mContext.startActivity(intent);
                        break;
                    case 1 :
                        Intent intent1 = new Intent(mContext,Mehrieh_Activity.class);
                        mContext.startActivity(intent1);
                        break;
                    case 2 :
                        Intent intent2 = new Intent(mContext,nimOrsh_Activity.class);
                        mContext.startActivity(intent2);
                        break;

                    case 3 :
                        Intent intent3 = new Intent(mContext,Davary_Activity.class);
                        mContext.startActivity(intent3);
                        break;
                    case 4 :
                        Intent intent4 = new Intent(mContext,KarshenasiActivity.class);
                        mContext.startActivity(intent4);
                        break;

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    public class myViewholder extends RecyclerView.ViewHolder {

        TextView time;
        ImageView iv;
        public myViewholder(@NonNull View itemView) {
            super(itemView);
            time = (TextView) itemView.findViewById(R.id.tv5);
            iv = (ImageView) itemView.findViewById(R.id.iv5);
        }
    }
}
