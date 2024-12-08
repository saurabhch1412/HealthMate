package com.example.heal_tech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1=
    {
        {"Name : Dr. Ajit Saste", "Fortis Escorts Hospital", "Exp : 5yrs","Mobile No: 9898989898","600"},
        {"Name : Dr. Prasad pawar", "Apollo Hospital", "Exp : 15yrs","Mobile No: 9797979797","900"},
        {"Name : Dr. Swapnil Kale", "Medanta Hospital", "Exp : 8yrs","Mobile No: 9696969696","300"},
        {"Name : Dr. Deepak Deshmukh", "Sakra Hospital", "Exp : 6yrs","Mobile No: 9595959595","1200"},
        {"Name : Dr. Ashok Pandey", "Artemis Hospital", "Exp : 7yrs","Mobile No: 9494949494","800"}
    };

    private String[][] doctor_details2=
            {
                    {"Name : Dr. Ajit Saste", "Fortis Escorts Hospital", "Exp : 5yrs","Mobile No: 9898989898","600"},
                    {"Name : Dr. Prasad pawar", "Apollo Hospital", "Exp : 15yrs","Mobile No: 9797979797","900"},
                    {"Name : Dr. Swapnil Kale", "Medanta Hospital", "Exp : 8yrs","Mobile No: 9696969696","300"},
                    {"Name : Dr. Deepak Deshmukh", "Sakra Hospital", "Exp : 6yrs","Mobile No: 9595959595","1200"},
                    {"Name : Dr. Ashok Pandey", "Artemis Hospital", "Exp : 7yrs","Mobile No: 9494949494","800"}
            };

    private String[][] doctor_details3=
            {
                    {"Name : Dr. Ajit Saste", "Fortis Escorts Hospital", "Exp : 5yrs","Mobile No: 9898989898","600"},
                    {"Name : Dr. Prasad pawar", "Apollo Hospital", "Exp : 15yrs","Mobile No: 9797979797","900"},
                    {"Name : Dr. Swapnil Kale", "Medanta Hospital", "Exp : 8yrs","Mobile No: 9696969696","300"},
                    {"Name : Dr. Deepak Deshmukh", "Sakra Hospital", "Exp : 6yrs","Mobile No: 9595959595","1200"},
                    {"Name : Dr. Ashok Pandey", "Artemis Hospital", "Exp : 7yrs","Mobile No: 9494949494","800"}
            };

    private String[][] doctor_details4=
            {
                    {"Name : Dr. Ajit Saste", "Fortis Escorts Hospital", "Exp : 5yrs","Mobile No: 9898989898","600"},
                    {"Name : Dr. Prasad pawar", "Apollo Hospital", "Exp : 15yrs","Mobile No: 9797979797","900"},
                    {"Name : Dr. Swapnil Kale", "Medanta Hospital", "Exp : 8yrs","Mobile No: 9696969696","300"},
                    {"Name : Dr. Deepak Deshmukh", "Sakra Hospital", "Exp : 6yrs","Mobile No: 9595959595","1200"},
                    {"Name : Dr. Ashok Pandey", "Artemis Hospital", "Exp : 7yrs","Mobile No: 9494949494","800"}
            };

    private String[][] doctor_details5=
            {
                    {"Name : Dr. Ajit Saste", "Fortis Escorts Hospital", "Exp : 5yrs","Mobile No: 9898989898","600"},
                    {"Name : Dr. Prasad pawar", "Apollo Hospital", "Exp : 15yrs","Mobile No: 9797979797","900"},
                    {"Name : Dr. Swapnil Kale", "Medanta Hospital", "Exp : 8yrs","Mobile No: 9696969696","300"},
                    {"Name : Dr. Deepak Deshmukh", "Sakra Hospital", "Exp : 6yrs","Mobile No: 9595959595","1200"},
                    {"Name : Dr. Ashok Pandey", "Artemis Hospital", "Exp : 7yrs","Mobile No: 9494949494","800"}
            };

    private String[][] doctor_details6=
            {
                    {"Name : Dr. Ajit Saste", "Fortis Escorts Hospital", "Exp : 5yrs","Mobile No: 9898989898","600"},
                    {"Name : Dr. Prasad pawar", "Apollo Hospital", "Exp : 15yrs","Mobile No: 9797979797","900"},
                    {"Name : Dr. Swapnil Kale", "Medanta Hospital", "Exp : 8yrs","Mobile No: 9696969696","300"},
                    {"Name : Dr. Deepak Deshmukh", "Sakra Hospital", "Exp : 6yrs","Mobile No: 9595959595","1200"},
                    {"Name : Dr. Ashok Pandey", "Artemis Hospital", "Exp : 7yrs","Mobile No: 9494949494","800"}
            };


TextView tv;
Button btn;

String[][] doctor_details={};
HashMap<String,String> item;
ArrayList list;
SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv=findViewById(R.id.textViewHATitle);
        btn=findViewById(R.id.buttonHADBack);

        Intent it=getIntent();
        String title =it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physician")==0)
            doctor_details=doctor_details1;
        else if (title.compareTo("Dentist")==0)
            doctor_details=doctor_details2;
        else if (title.compareTo("Surgeon")==0)
            doctor_details=doctor_details3;
        else if (title.compareTo("Family Dietician")==0)
            doctor_details=doctor_details4;
        else if (title.compareTo("cardiologist")==0)
            doctor_details=doctor_details5;
        else
            doctor_details=doctor_details6;




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));

            }
        });

        list =new ArrayList();
        for(int i=0;i<doctor_details.length;i++)
        {
            item=new HashMap<String, String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line6","Consultation Fee"+doctor_details[i][4]+"/-");
            list.add(item);

        }
        sa=new SimpleAdapter(this,list,R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
        new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst=findViewById(R.id.listViewHA);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);

                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });

    }
}