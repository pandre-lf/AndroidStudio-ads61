package com.pauloandre.n2_http;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Random;

public class FollowerGit{
    public Follower getInformacao(String apiString){
        String jsonStr = ConexaoApi.getJsonFromApi(apiString);
        Follower resultado = parseJson(jsonStr);

        return resultado;
    }

    private Follower parseJson(String json) {
        try {
            Follower follower = new Follower();

            JSONArray jsonArr = new JSONArray(json);
            int randomIndex = new Random().nextInt(jsonArr.length());
            JSONObject jsonObj = jsonArr.getJSONObject(randomIndex);

            follower.setIdUsuario(jsonObj.getString("login"));

            String avatarUrl = jsonObj.getString("avatar_url");
            follower.setAvatar(downloadImage(avatarUrl));

            return follower;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Bitmap downloadImage(String url) {
        try {
            URL endereco = new URL(url);
            InputStream is = endereco.openStream();
            Bitmap img = BitmapFactory.decodeStream(is);
            is.close();

            return img;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
