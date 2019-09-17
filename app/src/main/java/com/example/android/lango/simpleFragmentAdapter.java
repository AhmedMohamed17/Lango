package com.example.android.lango;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Switch;

public class simpleFragmentAdapter extends FragmentPagerAdapter {
    public simpleFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                return new numbersFrgment();

            case 1:
                return new familyFragment();
            case 2:
                return new colorFragment();
            case 3:
                return new phrasesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "numbers";
            case 1:
                return "family";
            case 2:
                return "colors";
            case 3:
                return "phrases";
            default:
                return null;

        }
    }
}
