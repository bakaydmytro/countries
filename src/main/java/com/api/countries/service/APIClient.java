package com.api.countries.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class APIClient {

    private APIClient() {}

    public static String makeGetRequest(String url) throws IOException {
        URL apiUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

        try {
            connection.setRequestMethod("GET");

            try (InputStream inputStream = connection.getInputStream();
                 InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                 BufferedReader reader = new BufferedReader(inputStreamReader)) {

                return reader.lines().collect(Collectors.joining());
            }
        } finally {
            connection.disconnect();
        }
    }
}
