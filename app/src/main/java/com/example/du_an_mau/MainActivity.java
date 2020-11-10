package com.example.du_an_mau;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.du_an_mau.Adapter.SlideShowAdapter;
import com.example.du_an_mau.Fragment.HomeFragment;
import com.example.du_an_mau.Fragment.invoiceFragment;
import com.example.du_an_mau.Fragment.statistaitalFragment;
import com.example.du_an_mau.Fragment.typeBookFragment;
import com.example.du_an_mau.Model.Slideshpw;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    Fragment fragment = null;
//    ViewPager viewPager;
//    SlideShowAdapter slideShowAdapter;
//    Integer[] colors = null;
//    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
//    ArrayList<Slideshpw> modelSlideShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mytoolbar1 = findViewById(R.id.myToolbar);
        setSupportActionBar(mytoolbar1);
        drawerLayout = findViewById(R.id.dwber_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, mytoolbar1, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conainer, new HomeFragment());
        }
        degsinBottom();
//        deginSLideshow();
    }

//    public void deginSLideshow() {
//        modelSlideShow = new ArrayList<>();
//        modelSlideShow.add(new Slideshpw(R.drawable.slideshowandroid, "1", "1"));
//        modelSlideShow.add(new Slideshpw(R.drawable.slideshowandroid2, "2", "2"));
//        modelSlideShow.add(new Slideshpw(R.drawable.slideshowandroid3, "3", "3"));
//        modelSlideShow.add(new Slideshpw(R.drawable.slideshowandroid4, "4", "4"));
//        slideShowAdapter = new SlideShowAdapter(modelSlideShow, MainActivity.this);
//        viewPager = findViewById(R.id.viewPagerSlideShow);
//        viewPager.setAdapter(slideShowAdapter);
//        viewPager.setPadding(20, 0, 20, 0);
//        Integer[] color_itemp = {getResources().getColor(R.color.color1),getResources().getColor(R.color.color2),getResources().getColor(R.color.color3),getResources().getColor(R.color.color4)};
//        colors = color_itemp;
//        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                if (position < (slideShowAdapter.getCount() - 1) && position < (colors.length - 1)) {
//
//                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, colors[position], colors[position] + 1));
//                }else {
//                    viewPager.setBackgroundColor(colors[colors.length-1]);
//                }
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//
//    }

    public void degsinBottom() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        final Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem;
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                switch (menuItem.getItemId()) {
                    case R.id.bot_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conainer, new HomeFragment()).commit();
                        Toast.makeText(MainActivity.this, "Home Fragment", Toast.LENGTH_SHORT).show();
                        menuItem = menu.findItem(R.id.bot_home);
                        menuItem.setChecked(true);
                        break;

                    case R.id.bot_typeBook:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conainer, new typeBookFragment()).commit();
                        Toast.makeText(MainActivity.this, "Type book fragment", Toast.LENGTH_SHORT).show();
                        menuItem = menu.findItem(R.id.bot_typeBook);
                        menuItem.setChecked(true);

                        break;
                    case R.id.bot_invoice:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conainer, new invoiceFragment()).commit();
                        Toast.makeText(MainActivity.this, "Invoice", Toast.LENGTH_SHORT).show();
                        menuItem = menu.findItem(R.id.bot_invoice);
                        menuItem.setChecked(true);
                        break;
                    case R.id.statistical:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conainer, new statistaitalFragment()).commit();
                        Toast.makeText(MainActivity.this, "Statistical Fragment", Toast.LENGTH_SHORT).show();
                        menuItem = menu.findItem(R.id.statistical);
                        menuItem.setChecked(true);
                        break;
                }
                return false;
            }
        });

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem1;
        switch (menuItem.getItemId()) {
            case R.id.dwSach:
                Toast.makeText(this, "Home Fragment", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conainer, new HomeFragment()).commit();
                menuItem1 = menu.findItem(R.id.bot_home);
                menuItem1.setChecked(true);
                break;
            case R.id.dwKho:
                Toast.makeText(this, "Kho Fragment", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conainer, new invoiceFragment()).commit();
                menuItem1 = menu.findItem(R.id.bot_invoice);
                menuItem1.setChecked(true);

                break;
            case R.id.dwThongke:
                Toast.makeText(this, "Thong ke", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conainer, new statistaitalFragment()).commit();

                menuItem1 = menu.findItem(R.id.statistical);
                menuItem1.setChecked(true);
                break;
            case R.id.dwTypeBook:
                Toast.makeText(this, "Type Book", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conainer, new typeBookFragment()).commit();
                menuItem1 = menu.findItem(R.id.bot_typeBook);
                menuItem1.setChecked(true);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}