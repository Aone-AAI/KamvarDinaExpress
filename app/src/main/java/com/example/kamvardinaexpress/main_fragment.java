package com.example.kamvardinaexpress;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class main_fragment extends Fragment {

    View RootView;

    Context context;

    private RecyclerView recyclerView;
    private ArrayList<ghanon> imageModelArrayList;
    private ghanonAdapter adapter;
    private int[] myImageList = new int[]{R.drawable.margaa, R.drawable.civil_law,R.drawable.criminal_law, R.drawable.economy_law,R.drawable.public_law,R.drawable.registry_law,R.drawable.lawyer_law,R.drawable.family_law,R.drawable.rohani};
    private String[] myImageNameList = new String[]{"قانون اساسی","مدنی" ,"کیفری" ,"تجارت" ,"عمومی","ثبت" , "وکالت" ,"خانواده" ,"ویژه روحانیت"};


    private RecyclerView recyclerView2;
    private ArrayList<sana> imageModelArrayList2;
    private sanaAdapter adapter2;
    private int[] myImageList2 = new int[]{R.drawable.sana_eblagh, R.drawable.sana_vkala,R.drawable.sna_ashkhas,R.drawable.sana_sabtename};
    private String[] myImageNameList2 = new String[]{"ابلاغ" ,"اطلاع رسانی وکلا" , "اطلاع رسانی اشخاص" ,"ثبت نام ثنا"};

    private RecyclerView recyclerView3;
    private ArrayList<khabargozari> imageModelArrayList3;
    private KhabargozariAdapter adapter3;
    private int[] myImageList3 = new int[]{R.drawable.kamvaricond, R.drawable.mizan,R.drawable.isna,R.drawable.farse ,R.drawable.tabnak,R.drawable.press,R.drawable.navad};
    private String[] myImageNameList3 = new String[]{"کامور دینا" , "میزان" ,"ایسنا"   ,"فارس" , "تابناک" , "PressTV" , "نود"};


    private RecyclerView recyclerView4;
    private ArrayList<tools> imageModelArrayList4;
    private toolsAdapter adapter4;
    private int[] myImageList4 = new int[]{R.drawable.question ,R.drawable.mehrieh, R.drawable.nim,R.drawable.davari_aaa,R.drawable.karshenasi_aa };
    private String[] myImageNameList4 = new String[]{"سوالات متداول" , "محاسبه مهریه" , "محاسبه نیم عشر" ,"محاسبه داوری" ,"محاسبه کارشناسی" };
    public main_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RootView = inflater.inflate(R.layout.main_fragment, container, false);
        initViews();
        return RootView;

    }
    private ArrayList<ghanon> ghanon() {

        ArrayList<ghanon> list = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            ghanon Model = new ghanon();
            Model.setName(myImageNameList[i]);
            Model.setImage_drawable(myImageList[i]);
            list.add(Model);
        }

        return list;
    }

    private ArrayList<sana> sana(){

        ArrayList<sana> list = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            sana Model = new sana();
            Model.setName(myImageNameList2[i]);
            Model.setImage_drawable(myImageList2[i]);
            list.add(Model);
        }

        return list;
    }

    private ArrayList<khabargozari> khabargozari(){

        ArrayList<khabargozari> list = new ArrayList<>();

        for(int i = 0; i < 7; i++){
            khabargozari Model = new khabargozari();
            Model.setName(myImageNameList3[i]);
            Model.setImage_drawable(myImageList3[i]);
            list.add(Model);
        }

        return list;
    }

    private ArrayList<tools> tools(){

        ArrayList<tools> list = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            tools Model = new tools();
            Model.setName(myImageNameList4[i]);
            Model.setImage_drawable(myImageList4[i]);
            list.add(Model);
        }

        return list;
    }
    private void initViews(){
        recyclerView = (RecyclerView) RootView.findViewById(R.id.recycler);
        imageModelArrayList = ghanon();
        adapter = new ghanonAdapter(getContext(), imageModelArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));


        recyclerView2 = (RecyclerView) RootView.findViewById(R.id.recycler2);
        imageModelArrayList2 = sana();
        adapter2 = new sanaAdapter(getContext(), imageModelArrayList2);
        recyclerView2.setAdapter(adapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));


        recyclerView3 = (RecyclerView) RootView.findViewById(R.id.recycler3);
        imageModelArrayList3 = khabargozari();
        adapter3 = new KhabargozariAdapter(getContext(), imageModelArrayList3);
        recyclerView3.setAdapter(adapter3);
        recyclerView3.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));

        recyclerView4 = (RecyclerView) RootView.findViewById(R.id.recycler4);
        imageModelArrayList4 = tools();
        adapter4 = new toolsAdapter(getContext(), imageModelArrayList4);
        recyclerView4.setAdapter(adapter4);
        recyclerView4.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));




        SliderView sliderView = RootView.findViewById(R.id.imageSlider);
        SliderAdapterExample adapter = new SliderAdapterExample(context);
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();
    }

}
