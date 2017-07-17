package com.example.itrain.mymaterial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

class CustomAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public CustomAdapter(FragmentManager manager) {

        super(manager);
    }

    @Override
    public Fragment getItem(int position) {

        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();

    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);

    }

    @Override

    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);

    }

}
