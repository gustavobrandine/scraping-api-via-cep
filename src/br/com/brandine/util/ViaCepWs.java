package br.com.brandine.util;

import br.com.brandine.entity.Cep;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ViaCepWs {

    static String urlBase = "http://viacep.com.br/ws/";
    static int codigoSucesso = 200;

    public static Cep buscaCep (String cep) throws Exception{
        String urlViaCep = urlBase + cep + "/json";

        try {
            URL url = new URL(urlViaCep);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != codigoSucesso)
                throw new RuntimeException("Código de erro: " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String jsonEmString = JsonUtil.converteJsonEmString(resposta);

            Gson gson = new Gson();
            Cep cepJson = gson.fromJson(jsonEmString, Cep.class);

            return cepJson;
        } catch (Exception e) {
            throw new Exception("ERRO: " + e);
        }
    }
}
