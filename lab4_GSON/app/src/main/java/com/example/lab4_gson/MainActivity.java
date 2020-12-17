package com.example.lab4_gson;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
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
        murzik.name = "Мурзик";
        murzik.age = 9;
        murzik.color = Color.BLACK;
        murzik.address = new Address("Arbat", "Moscow", "Russia");

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

        Log.i("GSON", "Имя: " + cat.name
                + "\nВозраст: " + cat.age
                + "\nАдрес: " + cat.address.city);
    }



}