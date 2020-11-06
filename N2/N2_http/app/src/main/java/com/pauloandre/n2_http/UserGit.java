package com.pauloandre.n2_http;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class UserGit {
    public User getInformacao(String apiString){
        String jsonStr = ConexaoApi.getJsonFromApi(apiString);
        User resultado = parseJson(jsonStr);

        return resultado;
    }

    private User parseJson(String json) {
        try {
            User perfil = new User();

            JSONObject jsonObj = new JSONObject(json);

            perfil.setIdUsuario(jsonObj.getString("login"));
            perfil.setNome(jsonObj.getString("name"));

            String avatarUrl = jsonObj.getString("avatar_url");
            perfil.setAvatar(downloadImage(avatarUrl));

            return perfil;
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
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
