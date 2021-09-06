package com.example.bloconotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bloconotas.controller.NotaController;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
    }

    public void cadastrarNota(View v) {
        Intent intent = new Intent(this, ActivityExibirNota.class);
        intent.putExtra("id nota", 0);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        NotaController notaController = new NotaController(this);
        ArrayList<String> dataset = notaController.listaTituloNotas();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                dataset);
        listView.setAdapter(arrayAdapter);
    }
}