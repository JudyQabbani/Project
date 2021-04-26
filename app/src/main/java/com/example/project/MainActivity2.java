package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private EditText UserIDText;
    private EditText FirstNameText;
    private EditText LastNameText;
    private EditText PhoneNoText;
    private EditText EmailText;
    private Button bAdd;
    private Button bBack;
    private Button bUpdate;
    private Button bDelete;
    private String key;
    private String userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

            key = getIntent().getStringExtra("key");
            userId = getIntent().getStringExtra("userID");
            firstName = getIntent().getStringExtra("firstName");
            lastName = getIntent().getStringExtra("lastName");
            phoneNumber  = getIntent().getStringExtra("phoneNumber");
            emailAddress = getIntent().getStringExtra("emailAddress");

            UserIDText = (EditText) findViewById(R.id.Id);
            FirstNameText = (EditText) findViewById(R.id.First);
            LastNameText = (EditText) findViewById(R.id.Last);
            PhoneNoText = (EditText) findViewById(R.id.Phone);
            EmailText = (EditText) findViewById(R.id.Mail);

            bAdd = (Button) findViewById(R.id.badd);
            bBack = (Button) findViewById(R.id.bback);
            bUpdate = (Button) findViewById(R.id.bupdate);
            bDelete = (Button) findViewById(R.id.bdelete);


            bAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FirebaseDatabase user = new FirebaseDatabase();
                    user.setUserId(UserIDText.getText().toString());
                    user.setFirstName(FirstNameText.getText().toString());
                    user.setLastName(LastNameText.getText().toString());
                    user.setPhoneNumber(PhoneNoText.getText().toString());
                    user.setEmailAddress(EmailText.getText().toString());
                    new FirebaseHelper().addUser(user, new FirebaseHelper().DataStatus() {
                        @Override
                        public void DataIsLoaded(List<FirebaseDatabase> user, List<String> key) {
                            Toast.makeText(MainActivity2.this, "User has been added!", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void DataIsInserted() {

                        }

                        @Override
                        public void DataIsUpdated() {

                        }

                        @Override
                        public void DataIsDeleted() {

                        }
                    });
                }
            });

            bBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish(); return;
                }
            });

            bUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FirebaseDatabase user = new FirebaseDatabase();
                    user.setUserId(UserIDText.getText().toString());
                    user.setFirstName(FirstNameText.getText().toString());
                    user.setLastName(LastNameText.getText().toString());
                    user.setPhoneNumber(PhoneNoText.getText().toString());
                    user.setEmailAddress(EmailText.getText().toString());

                    new FirebaseHelper().updateUser(key, user, new FirebaseHelper().DataStatus() {
                        @Override
                        public void DataIsLoaded(List<FirebaseDatabase> user, List<String> key) {

                        }

                        @Override
                        public void DataIsInserted() {

                        }

                        @Override
                        public void DataIsUpdated() {
                            Toast.makeText(MainActivity2.this, "User has been updated!", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void DataIsDeleted() {

                        }
                    });
                }
            });

            bDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new FirebaseHelper().deleteUser(key, new FirebaseHelper().DataStatus() {
                        @Override
                        public void DataIsLoaded(List<FirebaseDatabase> user, List<String> key) {

                        }

                        @Override
                        public void DataIsInserted() {

                        }

                        @Override
                        public void DataIsUpdated() {

                        }

                        @Override
                        public void DataIsDeleted() {
                            Toast.makeText(MainActivity2.this, "User has been deleted!", Toast.LENGTH_LONG).show();
                            finish(); return;
                        }
                    });
                }
            });

    }
}