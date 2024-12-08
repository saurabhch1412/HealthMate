package com.example.heal_tech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.heal_tech.model.Doctor;
import com.example.heal_tech.model.Model;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderDetailsActivity extends AppCompatActivity {

  private RecyclerView rec_view;
  private AdapterList adapterList;
  private FirebaseDatabase database;
  private ArrayList<Doctor>list;
  private FirebaseAuth mauth;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        mauth = FirebaseAuth.getInstance();
        btn =findViewById(R.id.buttonODback);
        rec_view=(RecyclerView)findViewById(R.id.recview);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderDetailsActivity.this,HomeActivity.class));

                  }
        });

        database = FirebaseDatabase.getInstance();
        rec_view.setHasFixedSize(true);
        rec_view.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapterList = new AdapterList(list,OrderDetailsActivity.this);
        rec_view.setAdapter(adapterList);

        database.getReference("Users")
                .child(mauth.getCurrentUser().getUid())
                .addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                          // Doctor d = new Doctor();
                           // Log.d("and", "onDataChange: "+dataSnapshot.getKey().toString());


                            String val =   dataSnapshot.getKey();


                     FirebaseDatabase.getInstance().getReference("Users")
                                     .child(mauth.getCurrentUser().getUid())
                                             .child(val)
                                                     .addValueEventListener(new ValueEventListener() {

                                                         @Override
                                                         public void onDataChange(@NonNull DataSnapshot snapshot) {

                                                             Doctor d1 = snapshot.getValue(Doctor.class);
                                                             list.add(d1);
                                                             Log.d("and", "onDataChange: "+d1.getDoctorType());
                                                             Log.d("and", "onDataChange: "+d1.getName());
                                                             Log.d("and", "onDataChange: "+d1.getHospital());
                                                             Log.d("and", "onDataChange: "+d1.getMobileNo());


                                                         }

                                                         @Override
                                                         public void onCancelled(@NonNull DatabaseError error) {

                                                         }
                                                     });
                        }
                        adapterList.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
    }
}