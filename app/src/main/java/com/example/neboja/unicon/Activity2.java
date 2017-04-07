package com.example.neboja.unicon;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.content.Intent;
import android.widget.Toast;



public class Activity2 extends Activity{

    String value1;
    String value2;
    String inputValue;
    double result;

    Spinner spinner;
    Spinner spinner2;

    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;

    int color =1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        spinner = (Spinner) findViewById(R.id.sS1);

        adapter = new ArrayAdapter<String>(Activity2.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.sOptions));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner2 = (Spinner) findViewById(R.id.sS2);

        adapter2 = new ArrayAdapter<String>(Activity2.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.sOptions));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner2.setAdapter(adapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                value1  = item.toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item2 = parent.getItemAtPosition(position);
                value2  = item2.toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final EditText Temperature = (EditText) findViewById(R.id.etTemp);


        Button bConvert = (Button) findViewById(R.id.bconvertTemp);
        bConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputValue = Temperature.getText().toString();
                if (inputValue.matches("")||(inputValue.matches("."))) {
                    Toast.makeText(getApplicationContext(), "Please Enter value!!!", Toast.LENGTH_SHORT).show();
                } else {

                    result = calculate(Double.parseDouble(Temperature.getText().toString()), value1, value2);
                    double input = Double.parseDouble(Temperature.getText().toString());
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
        if (value1.equals("Fahrenheits") && value2.equals("Celsius")) {
            result = TempCon.f2c(input);
        }

        if (value1.equals("Celsius") && value2.equals("Celsius")) {
            result = input;
        }
        if (value1.equals("Fahrenheits") && value2.equals("Fahrenheits")) {
            result = input;

        }
        if (value1.equals("Fahrenheits") && value2.equals("Kelvins")) {
            result = TempCon.f2k(input);

        }
        if (value1.equals("Kelvins") && value2.equals("Fahrenheits")) {
            result = TempCon.k2f(input);
        }
        if (value1.equals("Kelvins") && value2.equals("Celsius")) {
            result = TempCon.k2c(input);

        }
        if (value1.equals("Celsius") && value2.equals("Kelvins")) {
            result = TempCon.c2k(input);
        }
        if (value1.equals("Kelvins") && value2.equals("Kelvins")) {
                result =input;

        }
        if (value1.equals("Celsius") && value2.equals("Fahrenheits")) {
            result =TempCon.c2f(input);

        }
        return result;
    }

}



