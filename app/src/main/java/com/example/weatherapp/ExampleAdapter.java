package com.example.weatherapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleVievHolder> {
    private ArrayList<ExampleItem> exampleList;

    public static class ExampleVievHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;

        public ExampleVievHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.tempRV);
            textView = itemView.findViewById(R.id.textCV);
        }
    }

    public ExampleAdapter (ArrayList<ExampleItem> exampleList) {
        this.exampleList = exampleList;
    }

    @NonNull
    @Override
    public ExampleVievHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleVievHolder exampleVievHolder = new ExampleVievHolder(v);
        return exampleVievHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleVievHolder holder, int position) {
        ExampleItem currentItem = exampleList.get(position);
        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.textView.setText(currentItem.getTextLine());

    }

    @Override
    public int getItemCount() {
        return exampleList.size();
    }
}
