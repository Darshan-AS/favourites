package com.example.android.favourites;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class FavouriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        ViewPager viewPager = findViewById(R.id.viewpager);
        FavouritesAdapter favouritesAdapter = new FavouritesAdapter(getSupportFragmentManager());

        viewPager.setAdapter(favouritesAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
