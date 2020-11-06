package com.pauloandre.n2_http;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityFollowers extends AppCompatActivity {
    private TextView idFollower;
    private ImageView avatar;
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers);

        GetFollowerData download = new GetFollowerData();

        idFollower = (TextView)findViewById(R.id.txtIdFollower);
        avatar = (ImageView)findViewById(R.id.imgAvatarFollower);

        download.execute();
    }

    private class GetFollowerData extends AsyncTask<Void, Void, Follower> {
        @Override
        protected void onPreExecute() {
            load = ProgressDialog.show(ActivityFollowers.this, "Aguarde...", "Buscando dados");
        }

        @Override
        protected Follower doInBackground(Void... params) {
            FollowerGit conversor = new FollowerGit();
            return conversor.getInformacao("https://api.github.com/users/pandre-lf/followers");
        }

        @Override
        protected void onPostExecute(Follower follower) {
            idFollower.setText(follower.getIdUsuario());
            avatar.setImageBitmap(follower.getAvatar());

            load.dismiss();
        }
    }
}