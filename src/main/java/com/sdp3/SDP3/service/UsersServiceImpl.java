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
    public Users loginUser(Users users) {
        Users u=usersRepository.findByEmail(users.getEmail());
        if(u==null){
            Users uv=new Users();
            uv.setEmail("new");
            return uv;
        }
        if((u.getEmail().equals(users.getEmail()))&&(u.getPassword().equals(users.getPassword()))){
            return u;
        }else {
            Users uv=new Users();
            uv.setEmail("epw");
            return uv;
        }
    }

    @Override
    public Users getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public Users getUserByUserId(Long userid) {

        return usersRepository.getById(userid);
    }
}
