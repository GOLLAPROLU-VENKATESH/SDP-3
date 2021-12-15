package com.sdp3.SDP3.repository;

import com.sdp3.SDP3.entites.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
    Users findByEmail(String email);
}
