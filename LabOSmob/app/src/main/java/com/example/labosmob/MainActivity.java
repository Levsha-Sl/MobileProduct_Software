package com.example.labosmob;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        TextView newText = (TextView) findViewById(R.id.textOutput);
        String S = newText.getText() + " " + Phraser.PhraserGen();
        newText.setText(S);
    }
}
