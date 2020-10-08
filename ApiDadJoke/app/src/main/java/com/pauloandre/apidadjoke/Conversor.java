package com.pauloandre.apidadjoke;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Conversor {
    public DadJoke getInfo(String end) {
        String jsonStr = ConexaoApi.getJsonFromApi(end);
        DadJoke resultado = parseJson(jsonStr);

        return resultado; // change
    }

    private DadJoke parseJson(String json) {
        try {
            DadJoke piada = new DadJoke();

            JSONObject jsonObj = new JSONObject(json);
            piada.setJokeId(jsonObj.getString("id"));
            piada.setJoke(jsonObj.getString("joke"));
            piada.setJokeStatus(jsonObj.getString("status"));

            return piada;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
