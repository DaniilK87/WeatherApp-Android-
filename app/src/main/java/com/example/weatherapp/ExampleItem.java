package com.example.weatherapp;

public class ExampleItem {
    public int getImageResource() {
        return imageView;
    }

    public String getTextLine() {
        return textView;
    }

    private int imageView;
    private String textView;

    public ExampleItem (int imageResource, String textLine) {
        this.imageView = imageResource;
        this.textView = textLine;
    }
}
