package com.example.android.favourites;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Darshan AS on 13-12-2017.
 */

class FavouritesAdapter extends FragmentStatePagerAdapter {

    FavouritesAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new TvShowsFragment();
            case 1: return new MoviesFragment();
            case 2: return new MusicFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "TV SHOWS";
            case 1: return "MOVIES";
            case 2: return "MUSIC";
        }
        return null;
    }
}
