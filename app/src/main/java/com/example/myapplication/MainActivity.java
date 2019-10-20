package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText height, weight;
    TextView result;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        calculate = (Button) findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });

    }

    private void calculateBMI(){
        String heightStr=height.getText().toString();
        String weightStr=weight.getText().toString();

        if (heightStr!=null && !"".equals(heightStr) && weightStr!=null && !"".equals(weightStr)){
            float heightValue = Float.parseFloat(heightStr)/100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi=weightValue/(heightValue*heightValue);


            displayBMI(bmi);

        }

    }
    private void displayBMI(float bmi){
        String bmiLabel="";

        if (bmi<=18.5){
            bmiLabel="Underweight";
        }else if ((bmi) >= 18.5 && (bmi) <= 24.9){
            bmiLabel=" healthy / Normal Weight";
        } else if (bmi >= 25 && bmi <= 29.9) {
            bmiLabel=" Overweight";
        }else {
            bmiLabel="Obese";
        }

        bmiLabel=bmi+"\n" +bmiLabel;

        result.setText(bmiLabel);



    }




}
