package com.class3.Controller;

import com.class3.model.Post;
import com.class3.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PostController {
    String INSERT_POST = "INSERT INTO post VALUES(?,?,?,?)";

    public boolean insertNewPost(Post post) throws Exception {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = DBUtil.getMySQlConnection();
            preparedStatement
                    = conn.prepareStatement(INSERT_POST);

            preparedStatement.setInt(1, post.getId());
            preparedStatement.setInt(2, post.getUserId());
            preparedStatement.setString(3, post.getTitle());
            preparedStatement.setString(4, post.getBody());

            if (( preparedStatement.executeUpdate() > 0 )) {
                System.out.println("Post add");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                preparedStatement.close();
                conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }
}

