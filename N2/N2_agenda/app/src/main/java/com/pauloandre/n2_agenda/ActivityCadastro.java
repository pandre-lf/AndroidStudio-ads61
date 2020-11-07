package com.pauloandre.n2_agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityCadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button botao = (Button)findViewById(R.id.btCadastrar);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nome = (EditText) findViewById(R.id.editNome);
                EditText telefone = (EditText) findViewById(R.id.editFone);

                String nomeStr = nome.getText().toString();
                String telefoneStr = telefone.getText().toString();

                BancoController crud = new BancoController(getBaseContext());
                String resultado = crud.inserirDados(nomeStr, telefoneStr);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }


}