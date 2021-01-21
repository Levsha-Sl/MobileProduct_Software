package a.empty_activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.menu_home);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int IdMenu_item = item.getItemId();
        switch (IdMenu_item) {
            case R.id.action_home:
                setContentView(R.layout.activity_main);
                setTitle(R.string.menu_home);
                return true;
            case R.id.action_buttonCpick:
                setContentView(R.layout.activity_buttonclick);
                setTitle(R.string.menu_buttonCpick);
                return true;
            case R.id.action_motionEvent:
                setContentView(R.layout.activity_motionevent);
                setTitle(R.string.menu_motionEvent);
                return true;
            case R.id.action_commonGestures:
                setContentView(R.layout.activity_commongestures);
                setTitle(R.string.menu_commonGestures);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void ButtonClick(View v) {
        v.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView statusText =
                                findViewById(R.id.textClick);
                        statusText.setText(R.string.buttonClick_text0);
                    }
                }
        );
        v.setOnLongClickListener(
                new Button.OnLongClickListener() {
                    public boolean onLongClick(View v) {
                        TextView statusText =
                                findViewById(R.id.textClick);
                        statusText.setText(R.string.buttonClick_text1);
                        return false;
                    }
                }
        );
    }
}