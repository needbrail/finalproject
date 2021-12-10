 package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

 public class MainActivity extends AppCompatActivity {

     private ConstraintLayout layout;
     private Object SharedPreferences;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         initChooseButton();

         layout = findViewById(R.id.layout);
     }

     public void onResume() {
         super.onResume();
         SharedPreferences sharedPref = getSharedPreferences("ActivityWeatherPreferences", Context.MODE_PRIVATE);
         int chooseoption = sharedPref.getInt("chooseoption", 0xFF00F00);
         layout.setBackgroundColor(chooseoption);

     }

     private void initChooseButton() {
         Button chooseButton = findViewById(R.id.buttonchoose);
         chooseButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(MainActivity.this, option_picker.class);
                 intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                 startActivity(intent);
             }
         });
     }

     private void setForEditing(boolean enabled) {
         EditText editContact = findViewById(R.id.editName);
 }