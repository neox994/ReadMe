package com.example.neboja.unicon;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class RActivity extends Activity {

    TextView tvFirstSpinner, tvSecondSpinner, tvResult,tvInputValue;
    String value1, value2;
    Double inputValue, result;
    Bundle bundle;
    int color;
    View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r);


            bundle = getIntent().getExtras();
            value1 = bundle.getString("FIRST_SPINNER");
            value2 = bundle.getString("SECOND_SPINNER");
            inputValue = bundle.getDouble("INPUT_VALUE");
            result = bundle.getDouble("RESULT");
            color = bundle.getInt("COLOR");

        if(color==1) {
            view = this.getWindow().getDecorView();
            view.setBackgroundResource(R.color.color2);
        }
        if(color==2) {
            view = this.getWindow().getDecorView();
            view.setBackgroundResource(R.color.color1);
        }
        if(color==3) {
            view = this.getWindow().getDecorView();
            view.setBackgroundResource(R.color.color3);
        }
        if(color==4) {
            view = this.getWindow().getDecorView();
            view.setBackgroundResource(R.color.color4);
        }
            tvInputValue = (TextView) findViewById(R.id.tvInputValue);
            tvInputValue.setText(String.valueOf(inputValue));
            tvFirstSpinner = (TextView) findViewById(R.id.tvFirstSpinner);
            tvFirstSpinner.setText(value1);
            tvResult = (TextView) findViewById(R.id.tvResult);
            tvResult.setText(String.valueOf(result));
            tvSecondSpinner = (TextView) findViewById(R.id.tvSecondSpinner);
            tvSecondSpinner.setText(value2);



    }
}

