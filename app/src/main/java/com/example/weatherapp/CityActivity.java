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
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class CityActivity extends AppCompatActivity {
    private CheckBox checkBox;
    private TextInputLayout textInputCity;
    Pattern checkCityName = Pattern.compile("Ufa\", \"Kazan\", \"Perm");
    private final static String[] city = new String[]{"Ufa", "Kazan", "Perm"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        checkBox = findViewById(R.id.checkBox);
        textInputCity = findViewById(R.id.cityInputLayout);
        textInputCity.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) return;
                TextView tv = (TextView) view;
                validate(tv,checkCityName,"Такого города нет в базе");
            }
        });
    }

    // проверка вводимого текста при выборе города
    private void validate(TextView tv, Pattern checkCityName, String message) {
        String value = tv.getText().toString();
        if (checkCityName.matcher(value).matches()) {
            hideError(tv);
        } else {
            showError(tv, message);
        }
    }

    //показываем ошибку
    private void showError(TextView tv, String message) {
        tv.setError(message);
    }

    // прячем ошибку
    private void hideError(TextView tv) {
        tv.setError(null);
    }

    public void onClick1(View view) {
        Uri address = Uri.parse("https://weather.rambler.ru/world/kuba/");
        Intent browser = new Intent(Intent.ACTION_VIEW, address);
        Intent intent = new Intent(this, MainActivity.class);
        if (checkBox.isChecked()) {
            startActivity(browser);
        }
        Snackbar.make(view,"Поиск города",Snackbar.LENGTH_LONG).show();

    }

    public void exitCity(View view) {
        finish();
    }
}

