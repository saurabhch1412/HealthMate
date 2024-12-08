package com.example.heal_tech;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.heal_tech.model.Doctor;
import com.example.heal_tech.model.Model;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder>{
    private final List<Doctor> doctorList;
    private final Context context;

    private FirebaseDatabase databaseReference = FirebaseDatabase.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    public AdapterList(List<Doctor>doctorList,Context context){
        this.doctorList = doctorList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterList.ViewHolder holder, int position) {

        Doctor doctor = doctorList.get(position);
        holder.mobileNo.setText(doctor.getMobileNo());
        holder.doctype.setText(doctor.getDoctorType());
        holder.hospitalTv.setText(doctor.getHospital());
        holder.doc_nameTv.setText(doctor.getName());

    }


    @Override
    public int getItemCount() {
        return doctorList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView doc_nameTv;
        private TextView hospitalTv;
        private TextView doctype;
        private TextView mobileNo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            doc_nameTv = itemView.findViewById(R.id.nameText_row);
            hospitalTv = itemView.findViewById(R.id.hospital_row);
            doctype = itemView.findViewById(R.id.dotortype_row);
            mobileNo = itemView.findViewById(R.id.mobileno_row);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}



