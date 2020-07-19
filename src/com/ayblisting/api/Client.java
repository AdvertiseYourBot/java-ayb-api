package com.ayblisting.api;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Client {
    static final String base = "https://api.ayblisting.com";

    public static Stats fetchStats() throws IOException, ParseException {
        JSONObject obj = get(base + "/stats");
        return new Stats(obj);
    }

    public static Bot fetchBot(String id) throws IOException, ParseException {
        JSONObject obj = get(base + "/bot?id=" + id);
        return new Bot(obj);
    }

    public static Category fetchCategory(String id) throws IOException, ParseException {
        JSONObject obj = get(base + "/category?id=" + id);
        return new Category(obj);
    }

    private static JSONObject get(String stringURL) throws IOException, ParseException {
        URL url = new URL(stringURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responsecode = conn.getResponseCode();

        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        } else {
            Scanner sc = new Scanner(url.openStream());
            StringBuilder inline = new StringBuilder();

            while(sc.hasNext()) {
                inline.append(sc.nextLine());
            }

            sc.close();

            JSONParser parse = new JSONParser();

            return (JSONObject) parse.parse(inline.toString());
        }
    }
}