package com.example.project;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class FirebaseHelper {
    private FirebaseDatabase Database;
    private DatabaseReference ReferenceDatan;
    private List<FirebaseDatabase> user = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<FirebaseDatabase> users, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseHelper() {
        Database = FirebaseDatabase.getInstance();
        ReferenceDatan = Database.getReference("users");
    }

    public void readUsers(final DataStatus dataStatus){
        ReferenceDatan.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                users.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : snapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    FirebaseDatabase data = keyNode.getValue(FirebaseDatabase.class);
                    user.add(data);
                }
                dataStatus.DataIsLoaded(user,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void addUser(FirebaseDatabase user, final DataStatus dataStatus){
        String key = ReferenceDatan.push().getKey();
        ReferenceDatan.child(key).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                dataStatus.DataIsInserted();
            }
        });
    }

    public void updateUser(String key, FirebaseDatabase user, final DataStatus dataStatus){
        ReferenceDatan.child(key).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                dataStatus.DataIsUpdated();
            }
        });
    }

    public void deleteUser(String key, final DataStatus dataStatus){
        ReferenceDatan.child(key).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsDeleted();
            }
        });
    }
}
