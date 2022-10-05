package com.example.contactandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ContactDetail extends AppCompatActivity {
    TextView phoneNumber , phoneName ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);
        phoneNumber = findViewById(R.id.phoneNumberDetail);
        phoneName = findViewById(R.id.phoneNameDetail);
        Contact contact = (Contact) getIntent().getSerializableExtra("dataContact");
        phoneNumber.setText(contact.getPhone());
        phoneName.setText(contact.getName());
    }
}