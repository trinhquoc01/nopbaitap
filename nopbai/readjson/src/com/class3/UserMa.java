package com.class3;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserMa {public void readUserFromAPI() throws Exception{
    try {
        URL url = new URL("https://jsonplaceholder.typicode.com/users");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        InputStreamReader inputStreamReader = new InputStreamReader(conn.getInputStream());
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuilder response = new StringBuilder();
        String stream;
        while ((stream = reader.readLine()) != null){
            response.append(stream);
        }
        reader.close();

          //Lấy dữ liệu từ api

        JSONArray jsonArray = new JSONArray(response.toString());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = (JSONObject) jsonArray.get(i);
            User username = new User();
            username.setId(Integer.parseInt(object.get("id").toString()));
            username.setName((object.get("name").toString()));
            username.setUsername(object.get("username").toString());
            username.setEmail(object.get("email").toString());

            //Adddress Object
            JSONObject addressObject = (JSONObject) object.get("address");
            username.address = new Address();
            username.address.setStreet(addressObject.get("street").toString());
            username.address.setSuite(addressObject.get("suite").toString());
            username.address.setCity(addressObject.get("city").toString());
            username.address.setZipcode(addressObject.get("zipcode").toString());

            //Location Object
            JSONObject geoObject = (JSONObject) addressObject.get("geo");
            username.address.loc = new Location();
            username.address.loc.setLat(geoObject.get("lat").toString());
            username.address.loc.setLng(geoObject.get("lng").toString());

            username.setPhone(object.get("phone").toString());


        }
        conn.disconnect();

    }catch (Exception e){
        throw new Exception(e.getMessage());
    }
}
}
