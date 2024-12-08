package com.example.heal_tech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        CardView familyPhysician=findViewById(R.id.cardFLFullBodyCheckup);
        familyPhysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
                it.putExtra("title","FULL BODY CHECKUP");
                startActivity(it);
            }
        });

        CardView bloodSugar=findViewById(R.id.cardLTBloodSugar);
        bloodSugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
                it.putExtra("title","BLOOD SUGAR TEST");
                startActivity(it);
            }
        });

        CardView covid=findViewById(R.id.cardLTCovid);
        covid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
                it.putExtra("title","COVID_19 DOSE");
                startActivity(it);
            }
        });

        CardView bloodTest=findViewById(R.id.cardLTBloodTest);
        bloodTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
                it.putExtra("title","BLOOD TEST");
                startActivity(it);
            }
        });

        CardView urineTest=findViewById(R.id.cardLTUrineTest);
        urineTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
                it.putExtra("title","URINE TEST");
                startActivity(it);
            }
        });

        CardView thyroidCheck=findViewById(R.id.cardLTThyroidCheck);
        thyroidCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
                it.putExtra("title","THYROID CHECK");
                startActivity(it);
            }
        });

    }
}