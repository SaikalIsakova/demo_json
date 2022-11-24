package com.company;

import com.company.microservice.OkHttpConnection;
import com.company.models.Post;
import com.company.service.PostService;
import com.company.service.impl.PostServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PostService service=new PostServiceImpl();

        Type itemsListType = new TypeToken<List<Post>>() {}.getType();
        OkHttpConnection connection=new OkHttpConnection();
        String response=connection.getJson();
       List<Post> list=new Gson().fromJson(response,itemsListType);
       System.out.println(list);

//       service.createPost(list);

    }
}
