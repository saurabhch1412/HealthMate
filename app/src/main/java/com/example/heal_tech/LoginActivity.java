package com.example.heal_tech;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText edUsername, edPassword;
    Button btn;
   private  FirebaseAuth mAuth;
    TextView tv;

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()!=null){
            Intent i  = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(i);
            finish();
        }


        edUsername=findViewById(R.id.editTextLoginUserName);
        edPassword=findViewById(R.id.editTextLoginPassword);
        btn=findViewById(R.id.buttonCheckoutBMCart);
        tv=findViewById(R.id.textViewNewUser);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= edUsername.getText().toString();
                String password = edPassword.getText().toString();
                if (email.length()==0 || password.length()==0) {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                }
                else {

                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Toast.makeText(LoginActivity.this, "Login Success",
                                                Toast.LENGTH_SHORT).show();
                                        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor=sharedPreferences.edit();
                                        editor.putString("username",email);
                                        //to save out value data with key and value
                                        editor.apply();
                                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));

                                    } else {
                                        // If sign in fails, display a message to the user.

                                        Toast.makeText(LoginActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });


                     }

            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });


    }
}