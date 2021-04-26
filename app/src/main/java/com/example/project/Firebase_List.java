package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class Firebase_List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase__list);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_users);

        new FirebaseHelper().readUsers(new FirebaseHelper().DataStatus() {
            @Override
            public void DataIsLoaded(List<FirebaseDatabase> user, List<String> key) {
                new Recycler().setConfig(mRecyclerView, Firebase_List.this, user, key);
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
}