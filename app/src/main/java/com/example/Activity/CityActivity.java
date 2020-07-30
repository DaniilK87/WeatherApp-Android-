package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

 public class CityActivity extends AppCompatActivity {
    private CheckBox checkBox;
    private TextInputLayout textInputCity;
    private String cityName = "Ufa";
    private Button serverButton;
    private WebView webView;
    private static final String TAG = "WebBrowser";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager manager;
    final String LOG_TAG = "myLogs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        checkBox = findViewById(R.id.checkBox);
        textInputCity = findViewById(R.id.cityInputLayout);

    }



    public void onClick1(View view) {
        Uri address = Uri.parse("https://weather.rambler.ru/world/kuba/");
        Intent browser = new Intent(Intent.ACTION_VIEW, address);
        Intent intent = new Intent(this, MainActivity.class);
        if (checkBox.isChecked()) {
            startActivity(browser);
        }
        if (!textInputCity.equals(cityName)) {
            TextInputLayout til = (TextInputLayout) findViewById(R.id.cityInputLayout);
            til.setError("Города в базе нет");
        }
        Snackbar.make(view,"Поиск города",Snackbar.LENGTH_LONG).show();
        Log.d(LOG_TAG,"Тут что то не так3");

    }
    // закрытие CityActivity
    public void exitCity(View view) {
        finish();
    }

}

