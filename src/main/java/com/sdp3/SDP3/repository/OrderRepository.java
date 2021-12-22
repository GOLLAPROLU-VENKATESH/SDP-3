package com.sdp3.SDP3.repository;

import com.sdp3.SDP3.entites.Orders;
import com.sdp3.SDP3.entites.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {

    Orders findByOrderId(String order_id);
}
