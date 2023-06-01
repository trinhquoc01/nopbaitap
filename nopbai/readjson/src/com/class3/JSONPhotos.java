package com.class3;

import com.class3.Controller.PhotoController;
import com.class3.Controller.PostController;
import com.class3.model.Photo;
import com.class3.model.Post;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONPhotos {
    PhotoController photoController = new PhotoController();

    public void readJSONFromAPIphoto() throws Exception {
        try {
            String apiUrl = "https://jsonplaceholder.typicode.com/photos";
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

            org.json.JSONArray jsonArray = new org.json.JSONArray(response.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                org.json.JSONObject photo
                        = (org.json.JSONObject) jsonArray.get(i);

                Photo newphoto = new Photo(
                        Integer.parseInt(photo.get("albumId").toString()),
                        Integer.parseInt(photo.get("id").toString()),
                        photo.get("url").toString(),
                        photo.get("title").toString(),
                        photo.get("thumbnailUrl").toString()
                );

                //insert into DB
                System.out.println("Inserting ........");
                photoController.insertNewPhoto(newphoto);

            }
        } catch (Exception e ) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }
}
