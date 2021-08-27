package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class IMCActivity extends AppCompatActivity {

    String nome;
    Double peso, altura, imc;
    TextView tvNome, tvPeso, tvAltura, tvImc, tvResultado;
    DecimalFormat dcFormat = new DecimalFormat("##,###,###,##0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imcactivity);

        Bundle bundle = getIntent().getExtras();
        nome = bundle.getString("nome");
        peso = bundle.getDouble("peso");
        altura = bundle.getDouble("altura");

        tvNome = findViewById(R.id.tvNome);
        tvPeso = findViewById(R.id.tvPeso);
        tvAltura = findViewById(R.id.tvAltura);
        tvImc = findViewById(R.id.tvImc);
        tvResultado = findViewById(R.id.tvResultado);
    }

    @Override
    protected void onStart() {
        super.onStart();

        tvNome.setText(nome);
        tvPeso.setText(peso.toString());
        tvAltura.setText(altura.toString());
        tvImc.setText(dcFormat.format(calculaIMC(peso, altura)));
        tvResultado.setText(classificaIMC(imc));

    }

    public Double calculaIMC(Double peso, Double altura) {
        imc = peso / (altura * altura);
        return imc;
    }

    public String classificaIMC(Double imc) {
        if (imc <= 18.5){
            return "Você está abaixo do peso";
        } else if (imc > 18.5 && imc <= 24.9){
            return "Você está no peso ideal";
        } else if (imc > 24.9 && imc <= 29.9){
            return "Você está um pouco acima do peso";
        } else if (imc > 29.9 && imc <= 34.9){
            return "Você está em obesidade nível I.";
        } else if (imc > 34.9 && imc <= 39.9){
            return "Você está em obesidade nível II (severa)";
        } else {
            return "Você está em obesidade nível III (mórbida)";
        }
    }
}