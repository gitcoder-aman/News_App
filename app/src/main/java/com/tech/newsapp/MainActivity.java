package com.tech.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.tech.newsapp.Adapter.PagerAdapter;

public class MainActivity extends AppCompatActivity {

    TabItem mHome,mScience,mHealth,mTechnology,mSports,mEntertainment;
    PagerAdapter mPagerAdapter;
    Toolbar mToolbar;
    ViewPager mViewPager;
    TabLayout mTabLayout;

    String api = "74f39d16444847ed86082a255e94ebe8";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        setSupportActionBar(mToolbar);

        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) { //directly on any tab

                int tabPosition = tab.getPosition();
                mViewPager.setCurrentItem(tabPosition);

                if(tabPosition == 0 || tabPosition == 1 || tabPosition == 2 || tabPosition == 3 || tabPosition == 4 || tabPosition == 5){
                    mPagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

    }

    public void init(){
        mToolbar = findViewById(R.id.toolbar);
        mHealth = findViewById(R.id.health);
        mHome = findViewById(R.id.home);
        mTechnology = findViewById(R.id.technology);
        mSports = findViewById(R.id.sports);
        mEntertainment = findViewById(R.id.entertainment);
        mScience = findViewById(R.id.science);
        mViewPager = findViewById(R.id.fragment_container);
        mTabLayout = findViewById(R.id.tabLayout);
    }
}