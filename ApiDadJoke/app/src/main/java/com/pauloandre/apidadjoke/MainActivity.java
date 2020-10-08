package com.pauloandre.apidadjoke;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView jokeId;
    private TextView jokeText;
    private TextView jokeStatus;
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadJoke download = new DownloadJoke();

        jokeId = (TextView)findViewById(R.id.txtJokeId);
        jokeText = (TextView)findViewById(R.id.txtJoke);
        jokeStatus = (TextView)findViewById(R.id.txtJokeStatus);

        download.execute();
    }

    private class DownloadJoke extends AsyncTask<Void, Void, DadJoke> {

        @Override
        protected void onPreExecute() {
            load = ProgressDialog.show(MainActivity.this, "Wait...", "Fetching dad joke");
        }

        @Override
        protected DadJoke doInBackground(Void... params) {
            Conversor util = new Conversor();
            return util.getInfo("https://icanhazdadjoke.com/");
        }

        @Override
        protected void onPostExecute(DadJoke piada) {
            jokeId.setText(piada.getJokeId());
            jokeText.setText(piada.getJoke());
            jokeStatus.setText(piada.getJokeStatus());

            load.dismiss();
        }
    }

}

