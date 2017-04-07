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


public class Activity5 extends Activity {

    String value1;
    String value2;
    double result;

    String inputValue;

    Spinner spinner;
    Spinner spinner2;

    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;

    int color = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        spinner = (Spinner) findViewById(R.id.sS1);

        adapter = new ArrayAdapter<String>(Activity5.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.sOptions4));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner2 = (Spinner) findViewById(R.id.sS2);

        adapter2 = new ArrayAdapter<String>(Activity5.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.sOptions4));
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

        final EditText Lenght = (EditText) findViewById(R.id.etLenght);


        Button bConvert = (Button) findViewById(R.id.bconvertLenght);
        bConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputValue = Lenght.getText().toString();
                if (inputValue.matches("")||(inputValue.matches("."))) {
                    Toast.makeText(getApplicationContext(), "Please Enter value!!!", Toast.LENGTH_SHORT).show();
                } else {
                    double input = Double.parseDouble(Lenght.getText().toString());

                    result = calculate(Double.parseDouble(Lenght.getText().toString()), value1, value2);

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
        if (value1.equals("Inches") && value2.equals("Centimeters")) {
            result = LenghtCon.inch2cm(input);
        }
        if (value1.equals("Centimeters") && value2.equals("Inches")) {
            result = LenghtCon.cm2inch(input);

        }
        if (value1.equals("Inches") && value2.equals("Inches")) {
            result = input;

        }
        if (value1.equals("Centimeters") && value2.equals("Centimeters")) {
            result = input;
        }

        if (value1.equals("Meters") && value2.equals("Centimeters")) {
        result = LenghtCon.m2cm(input);
    }
        if (value1.equals("Centimeters") && value2.equals("Meters")) {
            result = LenghtCon.cm2m(input);
        }
        if (value1.equals("Meters") && value2.equals("Meters")) {
            result = input;
        }
        if (value1.equals("Meters") && value2.equals("Inches")) {
            result = LenghtCon.m2inch(input);
        }
        if (value1.equals("Inches") && value2.equals("Meters")) {
            result = LenghtCon.inch2m(input);
        }

        return result;

    }
}


