package com.pauloandre.n1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView nome;
    private EditText editNome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = (TextView)findViewById(R.id.textViewNome);
        editNome = (EditText)findViewById(R.id.editTextNome);
    }

    public void enviarNome(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityNotas.class);
        String textoNome = editNome.getText().toString();
        intent.putExtra("EXTRA_NOME", textoNome);
        startActivity(intent);
    }
}
