package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SQL extends AppCompatActivity {
    String username, usermail, userpass;
    FirebaseAuth Auth = FirebaseAuth.getInstance();
    FirebaseUser currentUser = Auth.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_q_l);
        EditText name=(EditText)findViewById(R.id.user);
        EditText email=(EditText)findViewById(R.id.email);
        EditText pass=(EditText)findViewById(R.id.pass);
        Button sign=(Button)findViewById(R.id.button);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (name.getText().toString().isEmpty()|| email.getText().toString().isEmpty() ||pass.getText().toString().isEmpty()) {
                    Toast.makeText(SQLI.this, "Empty Fields are needed to register", Toast.LENGTH_LONG).show();
                }
                else {
                    username = name.getText().toString();
                    usermail = email.getText().toString();
                    userpass = pass.getText().toString();
                    addUser(usermail,userpass);
                }}});}


    public void addUser(String user_email,String user_pass){
        Auth.createUserWithEmailAndPassword(user_email, user_pass)
                .addOnCompleteListener(SQLI.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            currentUser = Auth.getCurrentUser();
                            Toast.makeText(SQLI.this, "Successful registration. " + currentUser.getEmail() + " is now added to the company's chatting application ", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(SQLI.this, "User Already Exists!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }}