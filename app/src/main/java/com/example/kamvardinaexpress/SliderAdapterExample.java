package com.example.kamvardinaexpress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.io.FileNotFoundException;

import static com.example.kamvardinaexpress.CheckConnection.inter;

public class SliderAdapterExample extends SliderViewAdapter<SliderAdapterExample.SliderAdapterVH> {

    private Context context;

    public SliderAdapterExample(Context context) {
        this.context = context;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
//        viewHolder.textViewDescription.setText("This is slider item " + position);



        switch (position) {
            case 0:

                {

                        if (inter) {
                            try {
                                Glide.with(viewHolder.itemView)
                                        .load("http://kamvardina.ir/AppImages/image_one.jpg")
                                        .into(viewHolder.imageViewBackground);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }



                }else{
                    Glide.with(viewHolder.itemView)
                            .load(R.drawable.site_image)
                            .into(viewHolder.imageViewBackground);
                }

            }

                break;
            case 1: {
                if (inter) {
                    try {
                        Glide.with(viewHolder.itemView)

                                // .load("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260")
                                .load("http://kamvardina.ir/AppImages/image_two.jpg")

                                .into(viewHolder.imageViewBackground);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else{
                    Glide.with(viewHolder.itemView)

                            .load(R.drawable.law_slider)

                            .into(viewHolder.imageViewBackground);
                }


            }
                break;
            case 2:
            {
                if (inter) {
                    try {
                        Glide.with(viewHolder.itemView)

                                // .load("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260")
                                .load("http://kamvardina.ir/AppImages/image_three.jpg")

                                .into(viewHolder.imageViewBackground);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }else{
                    Glide.with(viewHolder.itemView)

                            .load(R.drawable.image_two_slider)

                            .into(viewHolder.imageViewBackground);
                }


            }
                break;
            default:
            {
                if (inter) {
                    try {
                        Glide.with(viewHolder.itemView)

                                // .load("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260")
                                .load("http://kamvardina.ir/AppImages/image_four.jpg")

                                .into(viewHolder.imageViewBackground);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else{
                    Glide.with(viewHolder.itemView)

                            .load(R.drawable.international_court)

                            .into(viewHolder.imageViewBackground);
                }


            }
                break;

        }

    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return 4;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
           // textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }
    }
}