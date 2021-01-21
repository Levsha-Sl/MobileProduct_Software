package a.empty_activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
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
                setContentView(R.layout.activity_button_click);
                setTitle(R.string.menu_buttonCpick);
                Click(findViewById(R.id.button));
                return true;
            case R.id.action_motionEvent:
                setContentView(R.layout.activity_motion_event);
                setTitle(R.string.menu_motionEvent);
                Touch(findViewById(R.id.layout));
                return true;
            case R.id.action_commonGestures:
                /*setContentView(R.layout.activity_common_gestures);
                setTitle(R.string.menu_commonGestures);*/
                startActivity(new Intent(MainActivity.this, CommonGestures.class));
                break;
        }
        //return super.onOptionsItemSelected(item);
        return true;
    }


    public void Click(View v) {
        v.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                buttonClick(R.string.buttonClick_text0);
            }
        });
        v.setOnLongClickListener(new Button.OnLongClickListener() {
            public boolean onLongClick(View v) {
                buttonClick(R.string.buttonClick_text1);
                return false;
            }
        });
    }
    public void Touch(View v) {
        v.setOnTouchListener(new ConstraintLayout.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent m) {
                handleTouch(m);
                return true;
            }
        });
    }

    void buttonClick(int string) {
        TextView statusText = findViewById(R.id.textClick);
        statusText.setText(string);
    }
    void handleTouch(MotionEvent m){
        TextView textView1 = findViewById(R.id.textViewME);
        TextView textView2 = findViewById(R.id.textViewME2);

        int pointerCount = m.getPointerCount();

        for (int i = 0; i < pointerCount; i++)
        {
            int x = (int) m.getX(i);
            int y = (int) m.getY(i);
            int id = m.getPointerId(i);
            int action = m.getActionMasked();
            int actionIndex = m.getActionIndex();
            String actionString;

            switch (action)
            {
                case MotionEvent.ACTION_DOWN:
                    actionString = "DOWN";
                    break;
                case MotionEvent.ACTION_UP:
                    actionString = "UP";
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    actionString = "PNTR DOWN";
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    actionString = "PNTR UP";
                    break;
                case MotionEvent.ACTION_MOVE:
                    actionString = "MOVE";
                    break;
                default:
                    actionString = "";
            }

            String touchStatus = String.format
                    (getString(R.string.touchStatus), actionString,actionIndex,id,x,y);

            if (id == 0)
                textView1.setText(touchStatus);
            else
                textView2.setText(touchStatus);
        }
    }
}