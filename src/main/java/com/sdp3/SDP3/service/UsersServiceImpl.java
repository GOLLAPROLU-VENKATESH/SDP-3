package com.sdp3.SDP3.service;

import com.sdp3.SDP3.entites.Users;
import com.sdp3.SDP3.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;


    @Override
    public void saveUser(Users users) {
        usersRepository.save(users);
    }

    @Override
    public boolean loginUser(Users users) {
        Users u=usersRepository.findByEmail(users.getEmail());
//        System.out.println(u.getPassword()+" "+users.getPassword()+" "+u.getEmail()+" "+users.getEmail());
        if((u.getEmail().equals(users.getEmail()))&&(u.getPassword().equals(users.getPassword()))){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Users getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
}
