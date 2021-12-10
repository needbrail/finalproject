package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class option_picker extends AppCompatActivity {

    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        initOptionPicker();
        initRadioGroupChooseOption();
    }

    private void initOptionPicker() {
        SharedPreferences sharedPref = getSharedPreferences("OptionPickerPrefernces", Context.MODE_PRIVATE);
        int chooseoption = sharedPref.getInt("chooseoption", 0xFF000FF);
        RadioButton rbGrass = findViewById(R.id.radioGrass);
        RadioButton rbApples = findViewById(R.id.radioApples);
        RadioButton rbSky = findViewById(R.id.radioSky);
        RadioButton rbSnow = findViewById(R.id.radioSnow);
        if(chooseoption == 0xFF00FF0) {
            rbGrass.setChecked(true);
        } else if (chooseoption == 0xFFFF0000) {
            rbApples.setChecked(true);
        } else if (chooseoption == 0xFF000FF) {
            rbSky.setChecked(true);
        } else {
            rbSnow.setChecked(true);
        }
    }

    private void initRadioGroupChooseOption() {
        RadioGroup rg = findViewById(R.id.RadioGroupChooseOption);
        RadioButton rbGrass = findViewById(R.id.radioGrass);
        RadioButton rbApples = findViewById(R.id.radioApples);
        RadioButton rbSky = findViewById(R.id.radioSky);
        RadioButton rbSnow = findViewById(R.id.radioSnow);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rbGrass.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("OptionPickerPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("chooseoption", 0xFF00FF0);
                    editor.apply();
                } else if (rbApples.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("OptionPickerPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("chooseoption", 0xFFFF0000);
                    editor.apply();
                } else if (rbSky.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("OptionPickerPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("chooseoption", 0XFF7EC8E3);
                    editor.apply();
                } else {
                    SharedPreferences sp = getSharedPreferences("ColorPickerPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("choosecolor", 0xFFFFFF);
                    editor.apply();
                }
            }
        });
    }
}