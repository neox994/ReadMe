package com.example.neboja.unicon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton iButton = (ImageButton) findViewById(R.id.B1);
        iButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), Activity2.class);
                startActivity(myIntent);
            }
        });

        ImageButton iButton2 = (ImageButton) findViewById(R.id.B2);
        iButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), Activity3.class);
                startActivity(myIntent);
            }
        });

        ImageButton iButton3 = (ImageButton) findViewById(R.id.B3);
        iButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), Activity4.class);
                startActivity(myIntent);
            }
        });

        ImageButton iButton4 = (ImageButton) findViewById(R.id.B4);
        iButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), Activity5.class);
                startActivity(myIntent);
            }
        });
    }
}
