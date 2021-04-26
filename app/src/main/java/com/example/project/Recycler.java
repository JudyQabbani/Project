package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Recycler {
    private Context mContext;
    private userAdapter mUserAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<FirebaseDatabase> users, List<String> keys){
        mContext = context;
        mUserAdapter = new userAdapter(users, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mUserAdapter);
    }

    class userView extends Recycler.ViewHolder{
        private TextView mUserId;
        private TextView mFirstName;
        private TextView mLastName;
        private TextView mPhoneNumber;
        private TextView mEmailAddress;

        private String key;

        public userView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.list_items, parent, false));

            mUserId = (TextView) itemView.findViewById(R.id.textId);
            mFirstName = (TextView) itemView.findViewById(R.id.textfirst);
            mLastName = (TextView) itemView.findViewById(R.id.textlast);
            mPhoneNumber = (TextView) itemView.findViewById(R.id.textphone);
            mEmailAddress = (TextView) itemView.findViewById(R.id.textmail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, MainActivity2.class);
                    intent.putExtra("key", key);
                    intent.putExtra("userId", mUserId.getText().toString());
                    intent.putExtra("firstName", mFirstName.getText().toString());
                    intent.putExtra("lastName", mFirstName.getText().toString());
                    intent.putExtra("phoneNumber", mPhoneNumber.getText().toString());
                    intent.putExtra("emailAddress", mEmailAddress.getText().toString());

                    mContext.startActivity(intent);
                }
            });
        }
        public void bind(FirebaseDatabase user, String key){
            mUserId.setText(user.getUserId());
            mFirstName.setText(user.getFirstName());
            mLastName.setText(user.getLastName());
            mPhoneNumber.setText(user.getPhoneNumber());
            mEmailAddress.setText(user.getEmailAddress());
            this.key = key;
        }
    }
    class userAdapter extends RecyclerView.Adapter<userView>{
        private List<FirebaseDatabase> mUserList;
        private List<String> mKeys;

        public userAdapter(List<FirebaseDatabase> mUserList, List<String> mKeys) {
            this.mUserList = mUserList;
            this.mKeys = mKeys;
        }

        @Override
        public userView onCreateViewHolder(ViewGroup parent, int viewType) {
            return new userView(parent);
        }

        @Override
        public void onBindViewHolder(Recycler.userView holder, int position) {
            holder.bind(mUserList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mUserList.size();
        }
    }
}

