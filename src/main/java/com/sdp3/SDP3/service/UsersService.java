package com.sdp3.SDP3.service;

import com.sdp3.SDP3.entites.Users;

public interface UsersService {

    void saveUser(Users users);
    Users loginUser(Users users);
    Users getUserByEmail(String email);
    Users getUserByUserId(Long userid);
}
