package com.example.contactandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewww;
    ArrayList<Contact> arrContact;
    ContactAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewww = findViewById(R.id.listviewContact);
        arrContact = new ArrayList<>();
        listViewww.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contact contact = arrContact.get(i);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , ContactDetail.class);
                intent.putExtra("dataContact",contact);
                startActivity(intent);
            }
        });
    }

    public void handleClick(View view){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS},0);
        }
        ContentResolver contentResolver = getContentResolver();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = contentResolver.query(uri , null , null,null ,null);
        Log.i("CONTACT_PROVIDER_DEMO" , "TOTAL # of Contact :::" + Integer.toString(cursor.getCount()));
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                @SuppressLint("Range") String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                @SuppressLint("Range") String contactNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                Log.i("CONTACT_PROVIDER_DEMO" , "Contact Name :::" + contactName + " " + contactNumber);
                arrContact.add(new Contact(contactName , contactNumber));
            }
        }

//        arrContact.add(new Contact("Nguyen Dac Dat" ,"092857125"));
//        arrContact.add(new Contact("Nguyen Tuan Kiet" ,"092855525"));
//        arrContact.add(new Contact("Huynh Trong Khoa" ,"0928561625"));
//        arrContact.add(new Contact("Dang Huy Hoang" ,"0928569125"));
//        arrContact.add(new Contact("Cao Tuan Kiet" ,"0928563821"));
        adapter = new ContactAdapter(this , R.layout.rowdata , arrContact);
        listViewww.setAdapter(adapter);
    }









}