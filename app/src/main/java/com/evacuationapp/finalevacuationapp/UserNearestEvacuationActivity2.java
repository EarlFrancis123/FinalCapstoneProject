package com.evacuationapp.finalevacuationapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.evacuationapp.finalevacuationapp.ui.main.UserNearestSectionsPagerAdapter;
import com.evacuationapp.finalevacuationapp.databinding.ActivityUserNearestEvacuation2Binding;

public class UserNearestEvacuationActivity2 extends AppCompatActivity {

    private ActivityUserNearestEvacuation2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUserNearestEvacuation2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        UserNearestSectionsPagerAdapter sectionsPagerAdapter = new UserNearestSectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = binding.fab;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}