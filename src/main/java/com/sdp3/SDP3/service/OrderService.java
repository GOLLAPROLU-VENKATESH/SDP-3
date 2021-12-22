package com.sdp3.SDP3.service;

import com.sdp3.SDP3.entites.Orders;

public interface OrderService {
    void saveOrder(Orders o);
    Orders getOrderById(String order_id);
}
