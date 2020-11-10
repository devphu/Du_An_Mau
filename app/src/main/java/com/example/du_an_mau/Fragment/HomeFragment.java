package com.example.du_an_mau.Fragment;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.du_an_mau.Adapter.SlideShowAdapter;
import com.example.du_an_mau.Adapter.bookAdapter;
import com.example.du_an_mau.Dao.bookDao;
import com.example.du_an_mau.Fragment.DialogFragment.diaLog_Fragment;
import com.example.du_an_mau.Model.Book;
import com.example.du_an_mau.Model.Slideshpw;
import com.example.du_an_mau.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView recyclerViewHome;
    static bookAdapter adapter;
    static ArrayList<Book> arrayList;
    static bookDao dao;
    ViewPager viewPager;
    SlideShowAdapter slideShowAdapter;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    ArrayList<Slideshpw> modelSlideShow;
    Button addData;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homefragment, container, false);


        Context context;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        arrayList = new ArrayList<>();
        dao = new bookDao(getContext());
        arrayList = dao.readALl();
        adapter = new bookAdapter(getActivity(), arrayList);
        recyclerViewHome = view.findViewById(R.id.recyViewHome);
        recyclerViewHome.setLayoutManager(linearLayoutManager);
        recyclerViewHome.setAdapter(adapter);


        modelSlideShow = new ArrayList<>();

        modelSlideShow.add(new Slideshpw(R.drawable.slideshowandroid, "Đổi pascal thành python", "Bộ GD & DT quyết định đổi pascal thành python cho học sinh lớp 11"));
        modelSlideShow.add(new Slideshpw(R.drawable.slideshowandroid2, "10 Năm Cổng bạn đi học", "Quyết định miễn học phí cho học sinh cổng bạn 10 năm đi học"));
        modelSlideShow.add(new Slideshpw(R.drawable.slideshowandroid3, "Sếp hàng Đại Học", "Sếp hàng dài để được nộp hồ sơ để được đăng kí nhập học tại các trường đại học có tiếng ở tp hcm"));
        modelSlideShow.add(new Slideshpw(R.drawable.slideshowandroid4, "Học Tiếng Anh", "4 website dại tiếng anh tốt cho người mất gốc"));

        slideShowAdapter = new SlideShowAdapter(modelSlideShow, getContext());
        viewPager = view.findViewById(R.id.viewPagerSlideShow);
        viewPager.setAdapter(slideShowAdapter);
        viewPager.setPadding(20, 0, 20, 0);
        Integer[] color_itemp = {getResources().getColor(R.color.color1), getResources().getColor(R.color.color2), getResources().getColor(R.color.color3), getResources().getColor(R.color.color4)};
        colors = color_itemp;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (slideShowAdapter.getCount() - 1) && position < (colors.length - 1)) {

                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, colors[position], colors[position] + 1));
                } else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        addData = view.findViewById(R.id.btnAdd);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diaLog_Fragment diaLog_fragment = new diaLog_Fragment();
                diaLog_fragment.show(getChildFragmentManager(), "dialog_fragment");
            }
        });
        return view;
    }
    public static void updateAdapter(){
        arrayList.clear();
        arrayList.addAll(dao.readALl());
        adapter.notifyDataSetChanged();
    }


}
