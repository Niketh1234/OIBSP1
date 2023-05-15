package com.example.unitconverter;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    private EditText cmEditText;
    private EditText mEditText;
    private Button toMeterButton;
    private Button toCmButton;

    private Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cmEditText = findViewById(R.id.cmEditText);
        mEditText = findViewById(R.id.mEditText);
        toMeterButton = findViewById(R.id.toMeterButton);
        toCmButton = findViewById(R.id.toCmButton);
        clear = findViewById(R.id.button2);

        toMeterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToMeter();
            }
        });

        toCmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToCm();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textClear();
            }
        });
    }

    private void convertToMeter() {
        String cmString = cmEditText.getText().toString().trim();
        if (!cmString.isEmpty()) {
            double cm = Double.parseDouble(cmString);
            double meters = cm / 100;
            mEditText.setText(String.valueOf(meters));
        }
    }

    private void convertToCm() {
        String mString = mEditText.getText().toString().trim();
        if (!mString.isEmpty()) {
            double meters = Double.parseDouble(mString);
            double cm = meters * 100;
            cmEditText.setText(String.valueOf(cm));
        }
    }

    private void textClear()
    {
        mEditText.setText("");
        cmEditText.setText("");
    }
}
