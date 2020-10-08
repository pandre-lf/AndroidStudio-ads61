package com.pauloandre.apidadjoke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConexaoApi {
    public static String getJsonFromApi(String url) {
        String resultado = "";
        try {
            URL apiEnd = new URL(url);
            HttpURLConnection conexao;

            conexao = (HttpURLConnection)apiEnd.openConnection();
            conexao.setRequestMethod("GET");
            conexao.setRequestProperty("Accept", "application/json");
            conexao.setReadTimeout(12000);
            conexao.setConnectTimeout(12000);
            conexao.connect();

            int codigoResposta = conexao.getResponseCode();
//            System.out.println(codigoResposta);
            InputStream is;
            //Verifica se o response code da conexao é 200 - ou HTTP OK
            if (codigoResposta == HttpURLConnection.HTTP_OK) {
                is = conexao.getInputStream();
            } else {
                is = conexao.getErrorStream();
            }

            resultado = converterInputStreamToString(is);
            is.close(); //fecha stream
            conexao.disconnect(); //encerra conexao
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Pegar json da API
        // https://icanhazdadjoke.com/api
        // https://taylor.rest/
        // https://github.com/public-apis/public-apis
        return resultado;
    }

    private static String converterInputStreamToString(InputStream is) {
        //Converter de stream para string
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader br;
            String linha;

            br = new BufferedReader(new InputStreamReader(is));
            while ((linha = br.readLine()) != null) {
                buffer.append(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }

}
