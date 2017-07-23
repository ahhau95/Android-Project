package com.example.hau.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class SelectionAndMapsActivity extends AppCompatActivity {

    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_and_maps);
        ViewPager vpPager = (ViewPager) findViewById(R.id.viewpagerview);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

    }


    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 2;

        public MyPagerAdapter(FragmentManager fragmentManager) {

            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {

            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: //This will show FirstFragment
                    return FirstFragment.newInstance(0, "HawkerStall");
                case 1: //This will show SecondFragment
                    return SecondFragment.newInstance(1, "Maps");

                default:
                    return null;
            }

        }

        @Override
        public CharSequence getPageTitle(int position) //return the page title name
        {
            if(position == 0)
                return "Hawkerstall" ;
            else
                return "Maps";
        }

    }
}
