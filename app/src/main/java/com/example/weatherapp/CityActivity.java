package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;

public class CityActivity extends AppCompatActivity {
    private CheckBox checkBox;
    private String city1 = "Ufa";
    private AutoCompleteTextView autoCompleteTextView;
    private final static String[] city = new String[]{"Ufa", "Kazan", "Perm"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        checkBox = findViewById(R.id.checkBox);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, city);
        autoCompleteTextView.setAdapter(adapter);
    }

    public void onClick1(View view) {
        Uri address = Uri.parse("https://weather.rambler.ru/world/kuba/");
        Intent browser = new Intent(Intent.ACTION_VIEW, address);
        Intent intent = new Intent(this, MainActivity.class);
        if (checkBox.isChecked()) {
            startActivity(browser);
        }


    }

    public void exitCity(View view) {
        finish();
    }
}

