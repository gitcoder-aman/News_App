package com.tech.newsapp.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.tech.newsapp.Fragment.EntertainmentFragment;
import com.tech.newsapp.Fragment.HealthFragment;
import com.tech.newsapp.Fragment.HomeFragment;
import com.tech.newsapp.Fragment.ScienceFragment;
import com.tech.newsapp.Fragment.SportsFragment;
import com.tech.newsapp.Fragment.TechnologyFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();

            case 1:
                return new SportsFragment();

            case 2:
                return new HealthFragment();

            case 3:
                return new ScienceFragment();

            case 4:
                return new EntertainmentFragment();

            case 5:
                return new TechnologyFragment();

            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 6;
    }
}
