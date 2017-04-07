package com.example.neboja.unicon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class Activity3 extends Activity{

    String  value1;
    String  value2;
    String inputValue;
    double result;

    Spinner spinner;
    Spinner spinner2;

    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;

    int color =2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        spinner = (Spinner) findViewById(R.id.sS3);
        adapter = new ArrayAdapter<String>(Activity3.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.sOptions2));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner2 = (Spinner) findViewById(R.id.sS4);
        adapter2 = new ArrayAdapter<String>(Activity3.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.sOptions2));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                value1 = item.toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item2 = parent.getItemAtPosition(position);
                value2 = item2.toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final EditText Speed = (EditText) findViewById(R.id.etSpeed);


        Button bConvert = (Button) findViewById(R.id.bconvertSpeed);
        bConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                inputValue = Speed.getText().toString();
               if (inputValue.isEmpty() || inputValue.equals(".")){
                   Toast.makeText(getApplicationContext(), "Please Enter value!!!", Toast.LENGTH_SHORT).show();
               } else {
                   double input = Double.parseDouble(Speed.getText().toString());

                   result = calculate(Double.parseDouble(Speed.getText().toString()), value1, value2);
                   Intent resultActivity;
                   resultActivity = new Intent(v.getContext(), RActivity.class);
                   Bundle bundle = new Bundle();
                   bundle.putString("FIRST_SPINNER", value1);
                   bundle.putString("SECOND_SPINNER", value2);
                   bundle.putDouble("INPUT_VALUE", input);
                   bundle.putDouble("RESULT", result);
                   bundle.putInt("COLOR", color);
                   resultActivity.putExtras(bundle);
                   startActivity(resultActivity);
               }

                }
            });
        }

    private double calculate(double input, String value1, String value2) {
        if (value1.equals("Miles per hour") && value2.equals("Kilometers per hour")) {
            result = SpeedCon.mph2kph(input);
        }
        if (value1.equals("Kilometers per hour") && value2.equals("Kilometers per hour")) {
            result = input;
        }
        if (value1.equals("Kilometers per hour") && value2.equals("Miles per hour")) {
            result = SpeedCon.kph2mph(input);
        }
        if (value1.equals("Miles per hour") && value2.equals("Miles per hour")) {
            result = input;
        }
        if (value1.equals("Meters per second") && value2.equals("Meters per second")) {
            result = input;

        }

        if (value1.equals("Miles per hour") && value2.equals("Meters per second")) {
            result = SpeedCon.mph2mps(input);
        }
        if (value1.equals("Meters per second") && value2.equals("Miles per hour")) {
            result = SpeedCon.mps2mph(input);
        }

        if (value1.equals("Meters per second") && value2.equals("Kilometers per hour")) {
            result = SpeedCon.mps2kph(input);
        }
        if (value1.equals("Kilometers per hour") && value2.equals("Meters per second")) {
            result = SpeedCon.kph2mps(input);
        }
    return result;
    }
}





