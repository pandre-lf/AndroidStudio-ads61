package com.pauloandre.httpapi;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView nome;
    private TextView sobrenome;
    private TextView email;
    private TextView cidade;
    private TextView username;
    private ImageView foto;
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadPerfil download = new DownloadPerfil();

        nome = (TextView)findViewById(R.id.textViewNome);
        sobrenome = (TextView)findViewById(R.id.textViewSobrenome);
        email = (TextView)findViewById(R.id.textViewEmail);
        cidade = (TextView)findViewById(R.id.textViewCidade);
        username = (TextView)findViewById(R.id.textViewUser);
        foto = (ImageView)findViewById(R.id.imageView);

        download.execute();
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    private class DownloadPerfil extends AsyncTask<Void, Void, Perfil> {

        @Override
        protected void onPreExecute() {
            load = ProgressDialog.show(MainActivity.this, "Aguarde...", "Obtendo informações");
        }

        @Override
        protected Perfil doInBackground(Void... params) {
            Conversor util = new Conversor();
            return util.getInformacao("https://randomuser.me/api/0.7");
        }

        @Override
        protected void onPostExecute(Perfil perfil) {
            nome.setText(perfil.getNome());
            sobrenome.setText(perfil.getSobrenome());
            email.setText(perfil.getEmail());
            cidade.setText(perfil.getCidade());
            username.setText(perfil.getUsername());
            foto.setImageBitmap(perfil.getFoto());

            load.dismiss();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}