package com.example.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;

import Models.Weather;
import Models.WeatherData;

 public class MainActivity extends AppCompatActivity {
    private TextView cityName;
    private TextView temp;
    private TextView wind;
    private TextView humidity;
    private TextView press;

    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toast toast = Toast.makeText(getApplicationContext(),"Приложение запущено",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
        toast.show();
        Log.d(LOG_TAG,"onCreate");



    }

   /*@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main, container, false);
        init(rootView);
        new Thread(() -> {
            String city = getArguments().getString("CITY");
            BufferedReader in = server.getJson(city);
            Gson gson = new GsonBuilder().create();
            final WeatherData weatherData = gson.fromJson(in, WeatherData.class);
            handler.post(() -> showWeather(weatherData));
        }).start();
        return rootView;
    }

    private void init (View view) {
        cityName = view.findViewById(R.id.cityNameText);
        temp = view.findViewById(R.id.textViewTerm);
        wind = view.findViewById(R.id.textViewWind);
        humidity = view.findViewById(R.id.textViewHumidity);
        press = view.findViewById(R.id.textViewBarometer);
    }

    private void showWeather (WeatherData weatherData) {
        cityName.setText(weatherData.getName());

    }*/

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast toast = Toast.makeText(getApplicationContext(),"Восстановление интерфейса",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
        toast.show();
        Log.d(LOG_TAG,"onRestoreInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast toast = Toast.makeText(getApplicationContext(),"Стоп",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
        toast.show();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }



     @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast toast = Toast.makeText(getApplicationContext(),"Сохранение состояния приложения",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
        toast.show();
        Log.d(LOG_TAG, "onSaveInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    // переход на активити с выбором города
    public void onMyClick(View view) {
        Intent intent = new Intent(this,CityActivity.class);
        startActivity(intent);
    }

    // показ фрагмента с почасовой погодой
    public void Change (View view) {
        Fragment fragment = null;

        switch (view.getId()) {
            case  R.id.showHourWeather:
                fragment = new hourWeatherFragment();
                Snackbar.make(view,"Показываю погоду по часам в течении суток",Snackbar.LENGTH_INDEFINITE).show();
                break;
            case R.id.closeHourWeather:
                fragment = new backfroundFragment();
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.weatherFrag,fragment);
        ft.commit();
    }


     public void startMenu(View view) {
        Intent intent = new Intent(this,NaviActivity.class);
        startActivity(intent);
     }
 }
