package com.evacuationapp.finalevacuationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class StaffAddEvacuationActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Button viewevacuationBtn, Savebtn;
    EditText CenterNameET,CenterAddressET, CenterNumberET, CenterTypeET, CenterBarangayET, CenterCapacityET;
    private Toolbar mainToolbar;
    private FirebaseAuth firebaseAuth;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("evacuation");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_add_evacuation);

        firebaseAuth = FirebaseAuth.getInstance();
        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.addevacuation);
        viewevacuationBtn = findViewById(R.id.viewEvacuationBtn);
        mainToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("Evacuation");

        Savebtn = findViewById(R.id.SaveBtn);
        CenterNameET = findViewById(R.id.centerNameET);
        CenterAddressET = findViewById(R.id.centerAddressET);
        CenterNumberET = findViewById(R.id.centerNumberET);
        CenterTypeET = findViewById(R.id.centerTypeET);
        CenterBarangayET = findViewById(R.id.centerBarangayET);
        CenterCapacityET = findViewById(R.id.centerCapacityET);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.addtypeofcalamity:
                        startActivity(new Intent(getApplicationContext(), StaffAddCalamityActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), StaffHomeActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.addevacuation:
                        return true;
                    case R.id.addevacuee:
                        startActivity(new Intent(getApplicationContext(), StaffAddEvacueeActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.settings:
                        startActivity(new Intent(getApplicationContext(), StaffSettingsActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
        Savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = CenterNameET.getText().toString();
                String address = CenterAddressET.getText().toString();
                String number = CenterNumberET.getText().toString();
                String type = CenterTypeET.getText().toString();
                String barangay = CenterBarangayET.getText().toString();
                String capacity = CenterCapacityET.getText().toString();
                HashMap<String, String> userMap = new HashMap<>();

                userMap.put("capacity", capacity);
                userMap.put("barangay", barangay);
                userMap.put("type", type);
                userMap.put("number", number);
                userMap.put("address", address);
                userMap.put("name", name);

                root.push().setValue(userMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(StaffAddEvacuationActivity.this, "Calamity Details Added", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(StaffAddEvacuationActivity.this, "Error! Calamity Details Added" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        viewevacuationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewCalamity();
            }
        });

    }
    public void openViewCalamity() {
        Intent intent = new Intent(this, StaffViewEvacuationActivity.class);
        startActivity(intent);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.profile_menu){
            startActivity(new Intent(StaffAddEvacuationActivity.this , SetUpActivity.class));
        }else if(item.getItemId() == R.id.sign_out_menu){
            firebaseAuth.signOut();
            startActivity(new Intent(StaffAddEvacuationActivity.this , SignInActivity.class));
            finish();
        }
        return true;
    }
}