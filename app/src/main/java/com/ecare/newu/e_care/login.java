package com.ecare.newu.e_care;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.ecare.newu.e_care.Ambulance.Main2Activity;
import com.ecare.newu.e_care.police.Main3Activity;
import com.ecare.newu.e_care.public_portal.public_main;

public class login extends AppCompatActivity {

    ImageButton b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1= (ImageButton) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(login.this, public_main.class);
                startActivity(i);
            }
        });
        b3= (ImageButton) findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(login.this, Main2Activity.class);
                startActivity(i);
            }
        });
        b2= (ImageButton) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(login.this, Main3Activity.class);
                startActivity(i);
            }
        });
    }
}
