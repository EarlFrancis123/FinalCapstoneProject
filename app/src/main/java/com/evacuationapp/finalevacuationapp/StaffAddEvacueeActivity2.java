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

import com.evacuationapp.finalevacuationapp.ui.main.AddEvacueeSectionsPagerAdapter;
import com.evacuationapp.finalevacuationapp.databinding.ActivityStaffAddEvacuee2Binding;

public class StaffAddEvacueeActivity2 extends AppCompatActivity {

    private ActivityStaffAddEvacuee2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityStaffAddEvacuee2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AddEvacueeSectionsPagerAdapter sectionsPagerAdapter = new AddEvacueeSectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);



    }
}