package com.example.mobileapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ContactDescription extends AppCompatActivity {

    TextView node_id;
    TextView name;
    TextView description;
    TextView fork;
    TextView downloads_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_description);
        node_id=findViewById(R.id.node_id);
        name=findViewById(R.id.name);
        description=findViewById(R.id.description);
        fork=findViewById(R.id.fork);
        downloads_url=findViewById(R.id.downloads_url);

        Intent intent=getIntent();
        Contact contact=intent.getParcelableExtra("contactDetail");
        node_id.setText(contact.getNodeId());
        name.setText(contact.getName());
        description.setText(contact.getDescription());
        fork.setText(contact.getFork());
        downloads_url.setText(contact.getDownloadUrl());
    }
}