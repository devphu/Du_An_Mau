package com.example.du_an_mau.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;

import com.example.du_an_mau.Model.Slideshpw;
import com.example.du_an_mau.R;

import java.util.ArrayList;

public class SlideShowAdapter extends PagerAdapter {
    private ArrayList<Slideshpw> arrayList;
    private  LayoutInflater layoutInflater;
    private Context context;

    public SlideShowAdapter(ArrayList<Slideshpw> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = layoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.itemslideshow,container,false);
        ImageView img;
        TextView title,nd;
        img  = view.findViewById(R.id.imgSlideshow);
        title = view.findViewById(R.id.txtNameSlideShow);
        nd = view.findViewById(R.id.txtNdSlideShow);
        img.setImageResource(arrayList.get(position).getImg());
        title.setText(arrayList.get(position).getTitle());
        nd.setText(arrayList.get(position).getNd());
        container.addView(view,0);
        return view;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
    
}
