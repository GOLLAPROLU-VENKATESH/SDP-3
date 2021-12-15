package com.sdp3.SDP3.repository;

import com.sdp3.SDP3.entites.Blog;
import com.sdp3.SDP3.entites.Store;
import com.sdp3.SDP3.entites.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoreRepositoryTest {
    @Autowired
    private StoreRepository storeRepository;

    @Test
    public void createStore(){
        Users users=Users.builder()
                .firstName("G")
                .lastName("Venkatesh")
                .userName("venky")
                .phoneNumber("9100534673")
                .email("venkatesh@gmail.com")
                .password("Venky@1501").build();
        Blog blog1=Blog.builder().blogTitle("First Blog")
                .blogDescription("Description")
                .blogVideo("Videourl").build();
        Blog blog2=Blog.builder().blogTitle("Second Blog")
                .blogDescription("Description")
                .blogVideo("Videourl").build();
        Store store=Store.builder()
                .storeName("Edeals")
                .phoneNumber("9100534673")
                .email("Store@gmail.com")
                .users(users).blogs(List.of(blog1,blog2)).build();

        storeRepository.save(store);
    }
}