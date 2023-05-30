package com.class3;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

public class JSONManagement {
    public void readJSONFromAPI() throws Exception {
        try {
            String apiUrl = "https://jsonplaceholder.typicode.com/posts";
            URL url = new URL(apiUrl);

            // Create connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            System.out.println("Connected successfully");
            // Read response
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println(response.toString());

            org.json.JSONArray jsonArray = new org.json.JSONArray(response.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                Post post = new Post();
                post.setId(Integer.parseInt(jsonObject.get("id").toString()));
                post.setUserId(Integer.parseInt(jsonObject.get("UserId").toString()));
                post.setTitle(jsonObject.get("title").toString());
                post.setBody(jsonObject.get("body").toString());

                System.out.println(post.toString());
            }

            conn.disconnect();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
