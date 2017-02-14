package com.example.android.lifegoals;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

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

        } else {
            return new GoalListFragment();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }
}
