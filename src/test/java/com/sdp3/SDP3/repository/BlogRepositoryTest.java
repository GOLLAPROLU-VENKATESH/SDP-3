package com.sdp3.SDP3.repository;

import com.sdp3.SDP3.entites.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlogRepositoryTest {

    @Autowired
    private BlogRepository blogRepository;

    @Test
    public void postBlog(){
        Blog blog=Blog.builder().blogTitle("First Blog")
                .blogDescription("Description")
                .blogVideo("Videourl").build();
    }
}