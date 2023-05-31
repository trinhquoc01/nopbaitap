package com.class3;

public class MainClass {
    public static void main(String[] args) {
        try {
            JSONManagement json = new JSONManagement();
            json.readJSONFromAPI();
        } catch (Exception e ) {
            System.out.println(e.getMessage());
        }
    }
}
