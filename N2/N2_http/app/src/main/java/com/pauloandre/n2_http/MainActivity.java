package com.pauloandre.n2_http;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView idUsuario;
    private TextView nomeUsuario;
    private ImageView avatar;
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetApiData download = new GetApiData();

        idUsuario = (TextView)findViewById(R.id.textUserId);
        nomeUsuario = (TextView)findViewById(R.id.textName);
        avatar = (ImageView)findViewById(R.id.imgAvatar);

        download.execute();
    }

    private class GetApiData extends AsyncTask<Void, Void, User> {

        @Override
        protected void onPreExecute() {
            load = ProgressDialog.show(MainActivity.this, "Aguarde...", "Buscando dados");
        }

        @Override
        protected User doInBackground(Void... params) {
            UserGit conversor = new UserGit();
            return conversor.getInformacao("https://api.github.com/users/pandre-lf");
        }

        @Override
        protected void onPostExecute(User perfil) {
            idUsuario.setText(perfil.getIdUsuario());
            nomeUsuario.setText(perfil.getNome());
            avatar.setImageBitmap(perfil.getAvatar());

            load.dismiss();
        }
    }

    public void ListFollowers(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityFollowers.class);
        //msg
        //intent.putExtra("EXTRA_", );
        startActivity(intent);
    }


}