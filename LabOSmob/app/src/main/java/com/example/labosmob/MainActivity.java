package com.example.labosmob;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView TOutput;
    TextView tv_result;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        TOutput = (TextView) findViewById(R.id.textOutput);
        tv_result = (TextView) findViewById(R.id.tv_result);
        Button newButton = (Button) findViewById(R.id.gen);

        result = Phraser.PhraserGen();

        String S = TOutput.getText() + " " + result + ".";
        TOutput.setText(S);
        S = result.replaceFirst(Character.toString(result.charAt(0)),Character.toString(result.charAt(0)).toUpperCase())
                +" "+ tv_result.getText();
        tv_result.setText(S);

        View.OnClickListener oclBtnGen = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = Phraser.PhraserGen();
                String S = getString(R.string.textOutput) + " " + result + ".";
                TOutput.setText(S);
                S = result.replaceFirst(Character.toString(result.charAt(0)),Character.toString(result.charAt(0)).toUpperCase())
                        +" "+ getString(R.string.tv_result);
                tv_result.setText(S);
            }
        };

        newButton.setOnClickListener(oclBtnGen);
    }
}
