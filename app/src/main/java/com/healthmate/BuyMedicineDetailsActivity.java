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
import com.example.heal_tech.R;
import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineDetailsActivity extends AppCompatActivity {

    private String[][] med_details1=
            {
                    {"Name : Sun Pharma", "Koramangala, Bengaluru", "Timing : 8am-9pm","Mobile No: 9898989898","Rating 4.8"},
                    {"Name : Ayurveda Pharmacy ", "Marathalli, Bengaluru", "Timing : 8am-11pm","Mobile No: 9797979797","Rating 3.8"},
                    {"Name : Apollo Pharmacy", "HSR, Bengaluru", "Timing : 9am-11pm","Mobile No: 9696969696","Rating 4.7"},
                    {"Name : Maruthi Medicals", "Sakra Hospital", "Timing : 10am-9pm","Mobile No: 9595959595","Rating 4.3"},
                    {"Name : Aster Pharmacy", "Artemis Hospital", "Timing : 10am-11pm","Mobile No: 9494949494","Rating 4.1"}
            };

    private String[][] med_details2=
            {
                    {"Name : Sun Pharma", "Koramangala, Bengaluru", "Timing : 8am-9pm","Mobile No: 9898989898","Rating 4.8"},
                    {"Name : Ayurveda Pharmacy ", "Marathalli, Bengaluru", "Timing : 8am-11pm","Mobile No: 9797979797","Rating 3.8"},
                    {"Name : Apollo Pharmacy", "HSR, Bengaluru", "Timing : 9am-11pm","Mobile No: 9696969696","Rating 4.7"},
                    {"Name : Maruthi Medicals", "Sakra Hospital", "Timing : 10am-9pm","Mobile No: 9595959595","Rating 4.3"},
                    {"Name : Aster Pharmacy", "Artemis Hospital", "Timing : 10am-11pm","Mobile No: 9494949494","Rating 4.1"}
            };

    private String[][] med_details3=
            {
                    {"Name : Sun Pharma", "Koramangala, Bengaluru", "Timing : 8am-9pm","Mobile No: 9898989898","Rating 4.8"},
                    {"Name : Ayurveda Pharmacy ", "Marathalli, Bengaluru", "Timing : 8am-11pm","Mobile No: 9797979797","Rating 3.8"},
                    {"Name : Apollo Pharmacy", "HSR, Bengaluru", "Timing : 9am-11pm","Mobile No: 9696969696","Rating 4.7"},
                    {"Name : Maruthi Medicals", "Sakra Hospital", "Timing : 10am-9pm","Mobile No: 9595959595","Rating 4.3"},
                    {"Name : Aster Pharmacy", "Artemis Hospital", "Timing : 10am-11pm","Mobile No: 9494949494","Rating 4.1"}
            };

    private String[][] med_details4=
            {
                    {"Name : Sun Pharma", "Koramangala, Bengaluru", "Timing : 8am-9pm","Mobile No: 9898989898","Rating 4.8"},
                    {"Name : Ayurveda Pharmacy ", "Marathalli, Bengaluru", "Timing : 8am-11pm","Mobile No: 9797979797","Rating 3.8"},
                    {"Name : Apollo Pharmacy", "HSR, Bengaluru", "Timing : 9am-11pm","Mobile No: 9696969696","Rating 4.7"},
                    {"Name : Maruthi Medicals", "Sakra Hospital", "Timing : 10am-9pm","Mobile No: 9595959595","Rating 4.3"},
                    {"Name : Aster Pharmacy", "Artemis Hospital", "Timing : 10am-11pm","Mobile No: 9494949494","Rating 4.1"}
            };

    private String[][] med_details5=
            {
                    {"Name : Sun Pharma", "Koramangala, Bengaluru", "Timing : 8am-9pm","Mobile No: 9898989898","Rating 4.8"},
                    {"Name : Ayurveda Pharmacy ", "Marathalli, Bengaluru", "Timing : 8am-11pm","Mobile No: 9797979797","Rating 3.8"},
                    {"Name : Apollo Pharmacy", "HSR, Bengaluru", "Timing : 9am-11pm","Mobile No: 9696969696","Rating 4.7"},
                    {"Name : Maruthi Medicals", "Sakra Hospital", "Timing : 10am-9pm","Mobile No: 9595959595","Rating 4.3"},
                    {"Name : Aster Pharmacy", "Artemis Hospital", "Timing : 10am-11pm","Mobile No: 9494949494","Rating 4.1"}
            };

    private String[][] med_details6=
            {
                    {"Name : Sun Pharma", "Koramangala, Bengaluru", "Timing : 8am-9pm","Mobile No: 9898989898","Rating 4.8"},
                    {"Name : Ayurveda Pharmacy ", "Marathalli, Bengaluru", "Timing : 8am-11pm","Mobile No: 9797979797","Rating 3.8"},
                    {"Name : Apollo Pharmacy", "HSR, Bengaluru", "Timing : 9am-11pm","Mobile No: 9696969696","Rating 4.7"},
                    {"Name : Maruthi Medicals", "Sakra Hospital", "Timing : 10am-9pm","Mobile No: 9595959595","Rating 4.3"},
                    {"Name : Aster Pharmacy", "Artemis Hospital", "Timing : 10am-11pm","Mobile No: 9494949494","Rating 4.1"}
            };

    TextView tv;
    Button btn;

    String[][] med_details={};

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_details);

        tv=findViewById(R.id.textViewHATitle);
        btn=findViewById(R.id.buttonHADBack);

        Intent it=getIntent();
        String title =it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Full Body Checkup")==0)
            med_details=med_details1;
        else if (title.compareTo("Blood Sugar Test")==0)
            med_details=med_details2;
        else if (title.compareTo("Covid19 Dose")==0)
            med_details=med_details3;
        else if (title.compareTo("Thyroid Check")==0)
            med_details=med_details4;
        else if (title.compareTo("Blood Test")==0)
            med_details=med_details5;
        else
            med_details=med_details6;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineDetailsActivity.this,BuyMedicineAcivity.class));

            }
        });


        list =new ArrayList();
        for(int i=0;i<med_details.length;i++)
        {
            item=new HashMap<String, String>();
            item.put("line1",med_details[i][0]);
            item.put("line2",med_details[i][1]);
            item.put("line3",med_details[i][2]);
            item.put("line4",med_details[i][3]);
            item.put("line6","Consultation Fee"+med_details[i][4]+"/-");
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
                Intent it=new Intent(BuyMedicineDetailsActivity.this,CartBuyMedicineActivty.class);

                it.putExtra("text1",title);
                it.putExtra("text2",med_details[i][0]);
                it.putExtra("text3",med_details[i][1]);
                it.putExtra("text4",med_details[i][3]);
                it.putExtra("text5",med_details[i][4]);
                startActivity(it);
            }
        });
    }
}