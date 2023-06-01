package com.class3.Controller;

import com.class3.model.Photo;
import com.class3.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PhotoController {
    String INSERT_PHOTO = "INSERT INTO post VALUES(?,?,?,?,?)";

    public boolean insertNewPhoto(Photo photo) throws Exception {
        Connection conn = null;
        PreparedStatement preparedStateme = null;
        try {

            conn = DBUtil.getMySQlConnection();
            preparedStateme
                    = conn.prepareStatement(INSERT_PHOTO);

            preparedStateme.setInt(1, photo.getAlbumId());
            preparedStateme.setInt(2, photo.getId());
            preparedStateme.setString(3, photo.getUrl());
            preparedStateme.setString(4, photo.getTitle());
            preparedStateme.setString(5, photo.getThumbnailUrl());

            if ((preparedStateme.executeUpdate() > 0)) {
                System.out.println("Photo add");

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                preparedStateme.close();
                conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }
}