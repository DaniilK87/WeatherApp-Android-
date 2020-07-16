package com.example.weatherapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String LOG_TAG = "myLogs";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast toast = Toast.makeText(getApplicationContext(),"Приложение запущено",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
        toast.show();
        Log.d(LOG_TAG,"onCreate");

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.thermometer,"+30C"));
        exampleList.add(new ExampleItem(R.drawable.thermometer,"+29C"));
        exampleList.add(new ExampleItem(R.drawable.thermometer,"+21C"));

        recyclerView = findViewById(R.id.tempRV);
        recyclerView.setHasFixedSize(true);
        manager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

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


    public void onMyClick(View view) {
        Intent intent = new Intent(this,CityActivity.class);
        startActivity(intent);
    }

    public void Change (View view) {
        Fragment fragment = null;

        switch (view.getId()) {
            case  R.id.shouHourWeather:
                fragment = new hourWeatherFragment();
                break;
            case R.id.sendHourWeather:
                fragment = new backfroundFragment();
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.weatherFrag,fragment);
        ft.commit();
    }
}
