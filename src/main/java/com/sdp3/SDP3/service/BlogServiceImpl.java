package com.sdp3.SDP3.service;

import com.sdp3.SDP3.entites.Blog;
import com.sdp3.SDP3.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
    }
}
