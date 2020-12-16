package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView List;
    private RViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initList();
    }

    ///получение RecyclerView
    private void initList(){
        List = findViewById(R.id.list);

        // будем отображать элементы линейно
        List.setLayoutManager(new LinearLayoutManager(this));

        //кто отвечает за заполнение элементов
        adapter = new RViewAdapter(DummyContent.ITEMS);
        List.setAdapter(adapter);
    }
}
