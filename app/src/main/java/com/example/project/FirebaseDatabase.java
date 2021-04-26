package com.example.project;

public class FirebaseDatabase {

        private String userID;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String emailAddress;

        public FirebaseDatabase() {
        }

        public FirebaseDatabase(String userId, String firstName, String lastName, String phoneNumber, String emailAddress) {
            this.userID = userId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;
        }

        public String getUserId() {
            return userID;
        }

        public void setUserId(String userId) {
            this.userID = userId;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }
    }

