package com.example.heal_tech;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.heal_tech.R;
import com.example.heal_tech.model.Lab;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;



public class CartLabActivity extends AppCompatActivity
{


    EditText ed1, ed2, ed3, ed4;
    TextView tv;
    private Button dateButton, timeButton, bookBtn;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;

    private DatabaseReference databaseReference;

    private FirebaseAuth mAuth;
    private Lab lab = new Lab();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_lab);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();


        tv = findViewById(R.id.textViewAppTitle);
        ed1 = findViewById(R.id.editTextAppFullName);
        ed2 = findViewById(R.id.editTextAppAddress);
        ed3 = findViewById(R.id.editTextAppNumber);
        ed4 = findViewById(R.id.editTextAppFees);
        dateButton = findViewById(R.id.buttonCartDatePicker);
        timeButton = findViewById(R.id.buttonCartTime);
        bookBtn = findViewById(R.id.buttonCheckoutBMCart);


        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);

        Intent it = getIntent();
        String title = it.getStringExtra("text1");
        String fullname = it.getStringExtra("text2");
        String address = it.getStringExtra("text3");
        String contact = it.getStringExtra("text4");
        int fees = Integer.parseInt(it.getStringExtra("text5"));

        tv.setText(title);

        ed1.setText(fullname);
        ed2.setText(address);
        ed3.setText(contact);
        ed4.setText("Service Charge " + fees + "/-");


        lab.setName(fullname);
        lab.setPackageName(title);
        lab.setAddress(address);
        lab.setMobileNo(contact);
        lab.setServiceCharge(fees);
        lab.setU_id(mAuth.getUid());


        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });


        initTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });


        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fireabse

                //writing to the real time db
                writeToDb(lab);
            }
        });


        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1 + 1;
                dateButton.setText(i2 + "/" + i1 + "/" + i);
                //date
                String date_1 = String.format("%d/%d/%d", i2, i1, i);
                lab.setBooked_date(date_1);
                datePickerDialog.show();
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis() + 86400000);
    }


    private void initTimePicker() {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                timeButton.setText(i + ":" + i1);
                //time
                String bookTime = i + ":" + i1;
                lab.setBooked_time(bookTime);
            }
        };

        Calendar cal = Calendar.getInstance();
        int hrs = cal.get(Calendar.HOUR);
        int mins = cal.get(Calendar.MINUTE);

        int style = AlertDialog.THEME_HOLO_DARK;
        timePickerDialog = new TimePickerDialog(this, style, timeSetListener, hrs, mins, true);

    }


    private void writeToDb(Object doctor) {
        String extraParams = String.valueOf(Calendar.getInstance().getTimeInMillis());
        databaseReference.child("Users").child(mAuth.getUid()).child(mAuth.getUid() + (extraParams))
                .setValue(doctor);
        Toast.makeText(this, "Written Successfully!", Toast.LENGTH_SHORT)
                .show();
    }
}



