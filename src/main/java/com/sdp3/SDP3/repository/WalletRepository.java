package com.sdp3.SDP3.repository;

import com.sdp3.SDP3.entites.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {

}
