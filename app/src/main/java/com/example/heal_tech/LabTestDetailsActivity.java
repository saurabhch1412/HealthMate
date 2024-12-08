package com.example.heal_tech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestDetailsActivity extends AppCompatActivity
{
    private String[][] lab_details1=
            {
                    {"Name : Thyrocare Aarogyam", "Koramangala, Bengaluru", "Service : 5yrs","Mobile No: 9898989898","600"},
                    {"Name : Dr. Lal pathlabs", "Marathalli, Bengaluru", "Service : 15yrs","Mobile No: 9797979797","900"},
                    {"Name : Apollo Diagnostics", "HSR, Bengaluru", "Service : 8yrs","Mobile No: 9696969696","300"},
                    {"Name : Metropolis Pathology", "Sakra Hospital", "Service : 6yrs","Mobile No: 9595959595","1200"},
                    {"Name : SRL Diagnostics", "Artemis Hospital", "Service : 7yrs","Mobile No: 9494949494","800"}
            };

    private String[][] lab_details2=
            {
                    {"Name : Thyrocare Aarogyam", "Koramangala, Bengaluru", "Service : 5yrs","Mobile No: 9898989898","600"},
                    {"Name : Dr. Lal pathlabs", "Marathalli, Bengaluru", "Service : 15yrs","Mobile No: 9797979797","900"},
                    {"Name : Apollo Diagnostics", "HSR, Bengaluru", "Service : 8yrs","Mobile No: 9696969696","300"},
                    {"Name : Metropolis Pathology", "Sakra Hospital", "Service : 6yrs","Mobile No: 9595959595","1200"},
                    {"Name : SRL Diagnostics", "Artemis Hospital", "Service : 7yrs","Mobile No: 9494949494","800"}
            };

    private String[][] lab_details3=
            {
                    {"Name : Thyrocare Aarogyam", "Koramangala, Bengaluru", "Service : 5yrs","Mobile No: 9898989898","600"},
                    {"Name : Dr. Lal pathlabs", "Marathalli, Bengaluru", "Service : 15yrs","Mobile No: 9797979797","900"},
                    {"Name : Apollo Diagnostics", "HSR, Bengaluru", "Service : 8yrs","Mobile No: 9696969696","300"},
                    {"Name : Metropolis Pathology", "Sakra Hospital", "Service : 6yrs","Mobile No: 9595959595","1200"},
                    {"Name : SRL Diagnostics", "Artemis Hospital", "Service : 7yrs","Mobile No: 9494949494","800"}
            };

    private String[][] lab_details4=
            {
                    {"Name : Thyrocare Aarogyam", "Koramangala, Bengaluru", "Service : 5yrs","Mobile No: 9898989898","600"},
                    {"Name : Dr. Lal pathlabs", "Marathalli, Bengaluru", "Service : 15yrs","Mobile No: 9797979797","900"},
                    {"Name : Apollo Diagnostics", "HSR, Bengaluru", "Service : 8yrs","Mobile No: 9696969696","300"},
                    {"Name : Metropolis Pathology", "Sakra Hospital", "Service : 6yrs","Mobile No: 9595959595","1200"},
                    {"Name : SRL Diagnostics", "Artemis Hospital", "Service : 7yrs","Mobile No: 9494949494","800"}
            };

    private String[][] lab_details5=
            {
                    {"Name : Thyrocare Aarogyam", "Koramangala, Bengaluru", "Service : 5yrs","Mobile No: 9898989898","600"},
                    {"Name : Dr. Lal pathlabs", "Marathalli, Bengaluru", "Service : 15yrs","Mobile No: 9797979797","900"},
                    {"Name : Apollo Diagnostics", "HSR, Bengaluru", "Service : 8yrs","Mobile No: 9696969696","300"},
                    {"Name : Metropolis Pathology", "Sakra Hospital", "Service : 6yrs","Mobile No: 9595959595","1200"},
                    {"Name : SRL Diagnostics", "Artemis Hospital", "Service : 7yrs","Mobile No: 9494949494","800"}
            };

    private String[][] lab_details6=
            {
                    {"Name : Thyrocare Aarogyam", "Koramangala, Bengaluru", "Service : 5yrs","Mobile No: 9898989898","600"},
                    {"Name : Dr. Lal pathlabs", "Marathalli, Bengaluru", "Service : 15yrs","Mobile No: 9797979797","900"},
                    {"Name : Apollo Diagnostics", "HSR, Bengaluru", "Service : 8yrs","Mobile No: 9696969696","300"},
                    {"Name : Metropolis Pathology", "Sakra Hospital", "Service : 6yrs","Mobile No: 9595959595","1200"},
                    {"Name : SRL Diagnostics", "Artemis Hospital", "Service : 7yrs","Mobile No: 9494949494","800"}
            };

    TextView tv;
    Button btn;

    String[][] lab_details={};

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);


        tv=findViewById(R.id.textViewHATitle);
        btn=findViewById(R.id.buttonHADBack);

        Intent it=getIntent();
        String title =it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Allergies")==0)
            lab_details=lab_details1;
        else if (title.compareTo("Cold/flu")==0)
            lab_details=lab_details2;
        else if (title.compareTo("Multivitamins")==0)
            lab_details=lab_details3;
        else if (title.compareTo("Oral iPills")==0)
            lab_details=lab_details4;
        else if (title.compareTo("Pain Killer")==0)
            lab_details=lab_details5;
        else
            lab_details=lab_details6;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetailsActivity.this,LabTestActivity.class));

            }
        });


        list =new ArrayList();
        for(int i=0;i<lab_details.length;i++)
        {
            item=new HashMap<String, String>();
            item.put("line1",lab_details[i][0]);
            item.put("line2",lab_details[i][1]);
            item.put("line3",lab_details[i][2]);
            item.put("line4",lab_details[i][3]);
            item.put("line6","Consultation Fee"+lab_details[i][4]+"/-");
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
                Intent it=new Intent(LabTestDetailsActivity.this,CartLabActivity.class);

                it.putExtra("text1",title);
                it.putExtra("text2",lab_details[i][0]);
                it.putExtra("text3",lab_details[i][1]);
                it.putExtra("text4",lab_details[i][3]);
                it.putExtra("text5",lab_details[i][4]);
                startActivity(it);
            }
        });
    }


}
