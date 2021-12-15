package com.sdp3.SDP3.repository;

import com.sdp3.SDP3.entites.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsersRepositoryTest {
    @Autowired
    private UsersRepository usersRepository;

    @Test
    public void registerUser(){
        Users users=Users.builder()
                .firstName("G")
                .lastName("Venkatesh")
                .userName("venky")
                .phoneNumber("9100534673")
                .email("venkatesh@gmail.com")
                .password("Venky@1501").build();
        usersRepository.save(users);
    }
}