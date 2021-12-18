package com.sdp3.SDP3.repository;

import com.sdp3.SDP3.entites.Product;
import com.sdp3.SDP3.entites.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
