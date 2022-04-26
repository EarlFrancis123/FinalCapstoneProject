package com.evacuationapp.finalevacuationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class StaffSettingsActivity extends AppCompatActivity {

    private Toolbar mainToolbar;
    private FirebaseAuth firebaseAuth;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_settings);


        firebaseAuth = FirebaseAuth.getInstance();
        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.settings);
        mainToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("Evacuation");

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.addtypeofcalamity:
                        startActivity(new Intent(getApplicationContext(),StaffAddCalamityActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), StaffHomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.addevacuation:
                        startActivity(new Intent(getApplicationContext(),StaffAddEvacuationActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.addevacuee:
                        startActivity(new Intent(getApplicationContext(),StaffAddEvacueeActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.settings:


                        return true;
                }
                return false;
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.profile_menu){
            startActivity(new Intent(StaffSettingsActivity.this , SetUpActivity.class));
        }else if(item.getItemId() == R.id.sign_out_menu){
            firebaseAuth.signOut();
            startActivity(new Intent(StaffSettingsActivity.this , SignInActivity.class));
            finish();
        }
        return true;
    }
}