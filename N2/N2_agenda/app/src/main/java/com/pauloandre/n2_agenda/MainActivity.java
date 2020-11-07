package com.pauloandre.n2_agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static int CADASTRO_SUCESSO = 12;
    public static int LISTAGEM_SUCESSO = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button buttonCadastrar = findViewById(R.id.btCadastrar);
//        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentCadastrar = new Intent(MainActivity.this, ActivityCadastro.class);
//                startActivityForResult(intentCadastrar, CADASTRO_SUCESSO);
//            }
//        });
//
//        Button buttonListar = findViewById(R.id.btNovo);
//        buttonListar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentListar = new Intent(MainActivity.this, ActivityAgenda.class);
//                startActivityForResult(intentListar, LISTAGEM_SUCESSO);
//            }
//        });
    }

    public void onClickCadastrar(View view) {
        Intent intentCadastrar = new Intent(MainActivity.this, ActivityCadastro.class);
        startActivityForResult(intentCadastrar, CADASTRO_SUCESSO);
    }

    public void onClickListar(View view) {
        Intent intentListar = new Intent(MainActivity.this, ActivityAgenda.class);
        startActivityForResult(intentListar, LISTAGEM_SUCESSO);
    }
}