package com.company.service.impl;

import com.company.dao.DbHelper;
import com.company.dao.impl.DbHelperImpl;
import com.company.models.Post;
import com.company.service.PostService;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PostServiceImpl implements PostService {

    DbHelper dbHelper=new DbHelperImpl();
    @Override
    public void createPost(List<Post> post) {

        for (int i = 1; i < post.size(); i++) {


            try {
            PreparedStatement ps = dbHelper.getConnection("insert into post_tb (user_Id,id,title,body) " +
                    "VALUES  (?,?,?,?)");
                ps.setLong(1,post.get(i).getUserId());
                ps.setLong(2, post.get(i).getId());
                ps.setString(3, post.get(i).getTitle());
                ps.setString(4, post.get(i).getBody());
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}
