package com.ecare.newu.e_care;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ecare.newu.e_care.Ambulance.Main2Activity;
import com.ecare.newu.e_care.public_portal.public_main;

public class login extends AppCompatActivity {

    Button b1,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1= (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(login.this, public_main.class);
                startActivity(i);
            }
        });
        b3= (Button) findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(login.this, Main2Activity.class);
                startActivity(i);
            }
        });
    }
}
