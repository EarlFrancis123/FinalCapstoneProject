package com.evacuationapp.finalevacuationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StaffViewReportsActivity extends AppCompatActivity {
Button MaleFemale,GeneralReport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_view_reports);
        MaleFemale = findViewById(R.id.reportsGenderBtn);
        GeneralReport = findViewById(R.id.generalReportBtn2);

        MaleFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StaffViewReportsActivity.this , StaffViewReportsActivityMaleAndFemale.class));
            }
        });
        GeneralReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StaffViewReportsActivity.this , StaffViewReportsActivityGeneralReports.class));
            }
        });
    }
}