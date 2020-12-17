package com.example.lab4_gson;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class MainActivity extends AppCompatActivity {

    String JsonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cat murzik = new Cat();
        murzik.name = "Муслин";
        murzik.age = 13;
        murzik.color = Color.GREEN;
        murzik.address = new Address("Улица", "Город", "Нашараша");

        CatToJson(murzik);
        CatFromJson(JsonText);
    }

    void CatToJson(Cat cat){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        JsonText = gson.toJson(cat);

        TextView tv_cat_json = (TextView) findViewById(R.id.tv_cat_json);
        tv_cat_json.setText("JsonText:\n" + JsonText);

        Log.i("GSON", JsonText);
    }

    void CatFromJson(String jsonText) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Cat cat = gson.fromJson(jsonText, Cat.class);

        TextView tv_cat = (TextView) findViewById(R.id.tv_cat);
        tv_cat.setText("Кот: " + cat.name + ", " + cat.age + "лет\nЦвет:");
        View cat_color = (View) findViewById(R.id.cat_color);
        cat_color.setBackgroundColor(cat.color);


        Log.i("GSON", "Имя: " + cat.name
                + "\nВозраст: " + cat.age
                + "\nАдрес: " + cat.address.city);
    }



}