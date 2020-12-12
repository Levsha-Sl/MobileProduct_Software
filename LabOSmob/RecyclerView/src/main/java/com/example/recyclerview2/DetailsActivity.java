package com.example.recyclerview2;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    final static String ARG_ITEM_ID = "com.example.EXTRA_ITEM_ID";
    private TextView tvDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        tvDetails = findViewById(R.id.tvDetails);
        tvDetails.setMovementMethod(new ScrollingMovementMethod());

        Intent intent = getIntent();
        String itemId = intent.getStringExtra(ARG_ITEM_ID);
        DummyItem item = DummyContent.getContent().getItemById(itemId);
        tvDetails.setText(item.details);

    }
}