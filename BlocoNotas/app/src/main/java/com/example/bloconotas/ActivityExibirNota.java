package com.example.bloconotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bloconotas.controller.NotaController;
import com.example.bloconotas.modelo.Nota;

public class ActivityExibirNota extends AppCompatActivity {

    NotaController notaController;
    EditText edTitulo, edTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_nota);
        notaController = new NotaController(getApplicationContext());

        edTitulo = findViewById(R.id.edTitulo);
        edTexto = findViewById(R.id.edTexto);
    }

    public void salvarNota(View v) {
     Nota nota = notaController.cadastrarNota(new Nota(edTitulo.getText().toString(), edTexto.getText().toString()));
        Toast.makeText(this, Integer.toString(nota.getId()), Toast.LENGTH_SHORT).show();
    }

}