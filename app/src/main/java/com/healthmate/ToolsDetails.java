package com.example.heal_tech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ToolsDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools_details);

        CardView bmicalci =findViewById(R.id.cardBMICalci);
        bmicalci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ToolsDetails.this,BmiCalculator.class));
            }
        });

        CardView healthArticle =findViewById(R.id.cardHealthArticles);
        healthArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ToolsDetails.this,HealthArticlesActivity.class));
            }
        });

        CardView imageClassify=findViewById(R.id.cardImageClassify);
        imageClassify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ToolsDetails.this,ImageClassifyActivity.class));
            }
        });

        CardView chatbot =findViewById(R.id.cardChatBot);
        chatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ToolsDetails.this,ChatBotActivity.class));
            }
        });


    }
}