package br.com.devqa.planningtime.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Tatiane on 26/05/2017.
 */

public class GoogleService {

    private static final String URL_GOOGLE = "https://maps.googleapis.com/maps/api/distancematrix/json?origins={origem}&destinations={destino}&mode=driving&language=pt-BR&key=AIzaSyAFewGkXHWKyNWvVoJ9Akrnf_j9WGr60NA";

    public static String obterJson(String origem, String destino) throws IOException {
        String endereco = URL_GOOGLE.replace("{origem}", formatarEndereco(origem)).replace("{destino}", formatarEndereco(destino));
        URL url = new URL(endereco);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        connection.connect();
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sr = new StringBuilder();
            String linha = "";
            while ((linha = br.readLine()) != null) {
                sr.append(linha);
            }
            return sr.toString();
        }
        return null;
    }

    private static String formatarEndereco(String endereco) {
        return endereco.replace(" ", "+");
    }
}
