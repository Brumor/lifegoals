package com.example.android.lifegoals;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import layout.NotificationFragment;

/**
 * Created by pbric on 12/02/2017.
 */

public class MainPageViewAdapter extends FragmentPagerAdapter {

    public MainPageViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NewsThreadFragment();

        } else if (position == 1){
            return new UserPageFragment();
        } else {
            return new NotificationFragment();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
