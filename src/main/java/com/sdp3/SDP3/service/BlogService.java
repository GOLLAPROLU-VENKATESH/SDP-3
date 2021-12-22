package com.sdp3.SDP3.service;

import com.sdp3.SDP3.entites.Blog;

import java.util.List;

public interface BlogService {
    void saveBlog(Blog blog);
    List<Blog> getAllBlogs();

    List<Blog> getBlogByStoreId(Long storeId);
}
