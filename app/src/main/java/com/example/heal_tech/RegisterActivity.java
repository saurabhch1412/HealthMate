package com.example.heal_tech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity
{

    EditText edUsername, edPassword, edConfirm;
    private FirebaseAuth mAuth;
    Button btn;
    TextView tv, edEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth=FirebaseAuth.getInstance();
        edUsername=findViewById(R.id.editTextAppFullName);
        edPassword=findViewById(R.id.editTextAppNumber);
        btn=findViewById(R.id.buttonCheckoutBMCart);
        tv=findViewById(R.id.textViewAccountUser);
        edConfirm=findViewById(R.id.editTextAppFees);
        edEmail=findViewById(R.id.editTextAppAddress);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String username=edUsername.getText().toString();
                String email=edEmail.getText().toString();
                String password=edPassword.getText().toString();
                String confirm=edConfirm.getText().toString();
               // Database db =new Database(getApplicationContext(),"Heal-Tech",null,1);

                if(username.length()==0 ||email.length()==0||password.length()==0||confirm.length()==0)
               {
                   Toast.makeText(getApplicationContext(),"Please fill all details",Toast.LENGTH_SHORT).show();
               }
               else
               { mAuth.createUserWithEmailAndPassword(email, password)
                       .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                               if (task.isSuccessful()) {
                                   Toast.makeText(RegisterActivity.this, "Account Created",
                                           Toast.LENGTH_SHORT).show();
                                   startActivity(new Intent(RegisterActivity.this,LoginActivity.class));

                               } else {
                                   // If sign in fails, display a message to the user.
                                   Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                           Toast.LENGTH_SHORT).show();

                               }
                           }
                       });

                   if (password.compareTo(confirm) == 0) {
                       if(isValid(password)) {
                           //db.register(username,email,password);
                           Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                       }
                       else {
                           Toast.makeText(getApplicationContext(),"Password must contain at least 8 characters having letters and digits",Toast.LENGTH_LONG).show();
                       }
                   }
                   else{
                           Toast.makeText(getApplicationContext(),"Password and Confirm Password didn't match",Toast.LENGTH_SHORT).show();
                   }

                   }
               }
        });
    }
    public static boolean isValid(String passwordHere)
    {
        int f1=0, f2=0,f3=0;
        if(passwordHere.length()<8)
        {
            return false;
        }
        else {
            for(int p=0;p<passwordHere.length();p++)
            {
                if(Character.isLetter(passwordHere.charAt(p)))
                {
                    f1=1;
                }
            }
            for(int r=0;r<passwordHere.length();r++)
            {
                if(Character.isDigit(passwordHere.charAt(r)))
                {
                    f2=1;
                }
            }



            }
            if (f1 == 1) if (f2 == 1) return true;
            return false;
        }
    }


