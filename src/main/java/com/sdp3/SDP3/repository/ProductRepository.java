package com.sdp3.SDP3.repository;

import com.sdp3.SDP3.entites.Product;
import com.sdp3.SDP3.entites.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "SELECT * FROM Product  WHERE product_id = ?1",nativeQuery = true)
    Product findByProductId(Long id);
}
