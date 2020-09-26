package com.example.gpa_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import static android.graphics.Color.RED;

public class MainActivity extends AppCompatActivity {

    private EditText e1, e2, e3, e4, e5;
    private String s1, s2, s3, s4, s5;
    private double g1, g2, g3, g4, g5;
    private Button b1;
    //TextWatcher used to check to make sure all textviewa are filled before the button is enabled
    private TextWatcher checkText = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            s1 = e1.getText().toString();
            s2 = e2.getText().toString();
            s3 = e3.getText().toString();
            s4 = e4.getText().toString();
            s5 = e5.getText().toString();
            b1.setEnabled(!s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty() && !s4.isEmpty() && !s5.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.grade1);
        e2 = findViewById(R.id.grade2);
        e3 = findViewById(R.id.grade3);
        e4 = findViewById(R.id.grade4);
        e5 = findViewById(R.id.grade5);
        b1 = findViewById(R.id.gpaButton);

        e1.addTextChangedListener(checkText);
        e2.addTextChangedListener(checkText);
        e3.addTextChangedListener(checkText);
        e4.addTextChangedListener(checkText);
        e5.addTextChangedListener(checkText);
        b1.setEnabled(false);


    }




    //Method: computeGPA
    //Purpose: takes the grades from the textviews and calculates the average
    //If average was already calculated, clears the textviews
    public void computeGPA(View view) {
        EditText et = findViewById(R.id.avgGrade);
        String s = et.getText().toString();
        if(s.isEmpty()) {
            g1 = Double.parseDouble(s1);
            g2 = Double.parseDouble(s2);
            g3 = Double.parseDouble(s3);
            g4 = Double.parseDouble(s4);
            g5 = Double.parseDouble(s5);
            double avg = (g1 + g2 + g3 + g4 + g5) / 5;
            et.setText(Double.toString(avg));
            b1.setText("Clear Form");
        }
        else
        {
            e1.setText("");
            e2.setText("");
            e3.setText("");
            e4.setText("");
            e5.setText("");
            et.setText("");
            b1.setText("Calculate GPA");
        }

    }
}