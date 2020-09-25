package com.pauloandre.n1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityNotas extends AppCompatActivity {

    private String nome;
    private EditText n1;
    private EditText n2;
    private TextView aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

        nome = getIntent().getStringExtra("EXTRA_NOME");
        n1 = (EditText)findViewById(R.id.editTextN1);
        n2 = (EditText)findViewById(R.id.editTextN2);
        aluno = (TextView)findViewById(R.id.textViewAluno);
        aluno.setText(nome);
    }

    protected double calcularMedia(double n1, double n2){
        return (n1 + n2)/2;
    }

    public void enviarNotas(View view) {
        Intent intent = new Intent(this, ActivityMedia.class);
        double n1double = Double.parseDouble(n1.getText().toString());
        double n2double = Double.parseDouble(n2.getText().toString());

        Double media = calcularMedia(n1double, n2double);
        String mediaTexto = media.toString();

        intent.putExtra("EXTRA_NOME", nome);
        intent.putExtra("EXTRA_MEDIA", mediaTexto);

        startActivity(intent);
    }
}