package com.example.labosmob;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView TOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        TOutput = (TextView) findViewById(R.id.textOutput);
        Button newButton = (Button) findViewById(R.id.gen);

        String S = TOutput.getText() + " " + Phraser.PhraserGen();
        TOutput.setText(S);

        View.OnClickListener oclBtnGen = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String S = getString(R.string.textOutput) + " " + Phraser.PhraserGen();
                TOutput.setText(S);
            }
        };

        newButton.setOnClickListener(oclBtnGen);
    }
}
