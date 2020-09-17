package com.pauloandre.httpapi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Conversor {

    public Perfil getInformacao(String end){
        String jsonStr = ConexaoApi.getJsonFromApi(end);
        Perfil resultado = parseJson(jsonStr);

        return resultado;
    }

    private Perfil parseJson(String json){
        try {
            Perfil perfil = new Perfil();

            JSONObject jsonObj = new JSONObject(json);
            JSONArray jsonArr = jsonObj.getJSONArray("results");

            JSONObject objArray = jsonArr.getJSONObject(0);

            JSONObject obj = objArray.getJSONObject("user");
            perfil.setEmail(obj.getString("email"));
            perfil.setUsername(obj.getString("username"));

            JSONObject nome = obj.getJSONObject("name");
            perfil.setNome(nome.getString("first"));
            perfil.setSobrenome(nome.getString("last"));

            JSONObject endereco = obj.getJSONObject("location");
            perfil.setCidade(endereco.getString("city"));

            JSONObject foto = obj.getJSONObject("picture");
            perfil.setFoto(baixarImagem(foto.getString("large")));

            return perfil;
        } catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }

    private Bitmap baixarImagem(String url) {
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