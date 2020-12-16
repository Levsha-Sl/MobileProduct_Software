package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    final static String ARG_ITEM_ID = "com.example.EXTRA_ITEM_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        TextView Details = findViewById(R.id.details);
        Details.setMovementMethod(new ScrollingMovementMethod());

        Intent intent = getIntent();

        //получили id элемена
        int itemId = Integer.parseInt(intent.getStringExtra(ARG_ITEM_ID));
        //найти элемент через id и вывести details
        DummyContent.DummyItem item = DummyContent.ITEMS.get(itemId-1);

        Details.setText(item.details);
    }
}