package com.example.heal_tech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.heal_tech.R;
public class BuyMedicineAcivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_acivity);

        CardView allergies=findViewById(R.id.cardBMAllergies);
        allergies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(BuyMedicineAcivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("title","ALLERGIES");
                startActivity(it);
            }
        });

        CardView coldflu=findViewById(R.id.cardBMColdFlu);
        coldflu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(BuyMedicineAcivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("title","COLD & FLU");
                startActivity(it);
            }
        });

        CardView multivitamin=findViewById(R.id.cardBMMultiVitamin);
        multivitamin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(BuyMedicineAcivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("title","MULTIVITAMIN");
                startActivity(it);
            }
        });

        CardView oralpills=findViewById(R.id.cardBMiPills);
        oralpills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(BuyMedicineAcivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("title","ORAL iPILLS");
                startActivity(it);
            }
        });

        CardView painkiller=findViewById(R.id.cardBMPainKiller);
        painkiller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(BuyMedicineAcivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("title","PAIN KILLER");
                startActivity(it);
            }
        });

        CardView antidepressant=findViewById(R.id.cardBMAntiDepressant);
        antidepressant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(BuyMedicineAcivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("title","ANTI DEPRESSANT");
                startActivity(it);
            }
        });

    }
}

