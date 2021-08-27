package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String [] dados = new String[] {"Cupcake", "Donut", "hamburguer", "Strogonoff de frango", "Bolo", "Brigadeiro"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                dados
        );

        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}