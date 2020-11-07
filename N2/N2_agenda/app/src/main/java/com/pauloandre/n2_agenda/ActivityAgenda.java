package com.pauloandre.n2_agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ActivityAgenda extends AppCompatActivity {
    List<String> lista = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        getData();

        ListView listaContatos = (ListView)findViewById(R.id.listAgenda);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listaContatos.setAdapter(adapter);
    }

    private void getData() {
        BancoController crud = new BancoController(getBaseContext());
        Cursor cur = crud.carregarDados();
        while(cur.moveToNext()) {
            int index;

            index = cur.getColumnIndexOrThrow("nome");
            String nome = cur.getString(index);

            index = cur.getColumnIndexOrThrow("telefone");
            String telefone = cur.getString(index);

            lista.add(nome + " - " + telefone);
        }
    }
}